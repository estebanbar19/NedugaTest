package com.test.nedugatest.ui.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.test.nedugatest.databinding.ActivityMainBinding;
import com.test.nedugatest.ui.viewmodel.AuthViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AuthViewModel authViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        authViewModel.authToken.observe(this, s -> {
            Intent productsActivity = new Intent(getApplicationContext(), ProductsActivity.class);
            startActivity(productsActivity);
        });

        authViewModel.authError.observe(this, error -> {
            binding.authMessage.setText(error);
            binding.authMessage.setVisibility(View.VISIBLE);
        });

        authViewModel.isLoading.observe(this, isLoading -> {
            if(isLoading){
                binding.authProgress.setVisibility(View.VISIBLE);
            }else{
                binding.authProgress.setVisibility(View.GONE);
            }
        });

        binding.email.setOnFocusChangeListener((v, hasFocus) -> binding.authMessage.setVisibility(View.GONE));
        binding.password.setOnFocusChangeListener((v, hasFocus) -> binding.authMessage.setVisibility(View.GONE));

        binding.btnIngresarLogin.setOnClickListener(v -> {
            binding.authMessage.setVisibility(View.GONE);
            String email = binding.email.getText().toString();
            String pass = binding.password.getText().toString();

            authViewModel.signIn(email, pass, getApplicationContext(), binding.keepSessionCheck.isChecked());
//            authViewModel.signIn("snyder", "f238&@*$", getApplicationContext(), binding.keepSessionCheck.isChecked());
        });

        String tokenSharedPreferences = getTokenFromSharedPreferences();
        if(!tokenSharedPreferences.equals("")){
            authViewModel.authToken.postValue(tokenSharedPreferences);
        }
    }

    private String getTokenFromSharedPreferences() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("auth", Context.MODE_PRIVATE);
        return sharedPreferences.getString("token", "");
    }
}