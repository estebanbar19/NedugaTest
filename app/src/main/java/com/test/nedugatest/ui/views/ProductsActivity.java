package com.test.nedugatest.ui.views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.nedugatest.R;
import com.test.nedugatest.ui.adapters.ProductsRecyclerViewAdapters;
import com.test.nedugatest.ui.viewmodel.ProductViewModel;

public class ProductsActivity extends AppCompatActivity {

    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        findViewById(R.id.productProgress).setVisibility(View.VISIBLE);
        productViewModel.onCreate(getApplicationContext());

        productViewModel.products.observe(this, productModels -> {
            RecyclerView recyclerView = findViewById(R.id.products_recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            recyclerView.setAdapter(new ProductsRecyclerViewAdapters(productModels));
        });

        productViewModel.isLoading.observe(this, aBoolean -> {
            if (aBoolean){
                findViewById(R.id.productProgress).setVisibility(View.VISIBLE);
            }else{
                findViewById(R.id.productProgress).setVisibility(View.GONE);
            }
        });

        findViewById(R.id.logout).setOnClickListener(v -> {
            getApplicationContext().getSharedPreferences("auth", Context.MODE_PRIVATE).edit().putString("token", "").apply();
            finish();
        });
    }
}
