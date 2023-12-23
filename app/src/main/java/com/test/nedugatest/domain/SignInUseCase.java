package com.test.nedugatest.domain;

import android.content.Context;

import com.google.gson.Gson;
import com.test.nedugatest.data.AuthRepository;
import com.test.nedugatest.data.models.AuthDataModel;

import java.util.Map;

public class SignInUseCase {

    private static AuthRepository authRepository = new AuthRepository();

    public static Map<String, Object> signIn(String email, String password, Context context, Boolean keepSession){
        Map<String, Object> response = authRepository.SignInWithApi(email, password);;
        if(response.get("code").equals(200) && keepSession){
            Gson gson = new Gson();
            AuthDataModel authDataModel = gson.fromJson(gson.toJson(response.get("token")), AuthDataModel.class);
            context.getSharedPreferences("auth", Context.MODE_PRIVATE).edit().putString("token", authDataModel.getToken()).apply();
        }
        return response;
    }
}
