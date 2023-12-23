package com.test.nedugatest.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.test.nedugatest.data.models.AuthDataModel;
import com.test.nedugatest.domain.SignInUseCase;

import java.util.Map;

public class AuthViewModel extends ViewModel {
    public MutableLiveData<String> authToken = new MutableLiveData<>();
    public MutableLiveData<String> authError = new MutableLiveData<>();

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public void signIn(String email, String password, Context context, Boolean keepSession){
        isLoading.postValue(true);
        if(email.isEmpty() || password.isEmpty()){
            authError.postValue("Por favor, ingrese todos los campos");
        }else {
            Map<String, Object> result = SignInUseCase.signIn(email, password, context, keepSession);
            if(result.get("code").equals(200)){
                Gson gson = new Gson();
                AuthDataModel authDataModel = gson.fromJson(gson.toJson(result.get("token")), AuthDataModel.class);
                authToken.postValue(authDataModel.getToken());
            }else{
                authError.postValue((String) result.get("error"));
            }
        }
        isLoading.postValue(false);
    }
}
