package com.test.nedugatest.data.network.FakeAPI;

import com.test.nedugatest.core.RetrofitHelper;
import com.test.nedugatest.data.models.UserLoginModel;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.FutureTask;

import retrofit2.Response;
import retrofit2.Retrofit;

public class FakeAPIAuthService {

    private Retrofit retrofit = RetrofitHelper.getRetrofit();

    public Map<String, Object> signIn(String user, String pass){

        UserLoginModel userlogin = new UserLoginModel(user, pass);
        FutureTask<Object> future = new FutureTask<>(() -> {
            Response<Object> response = retrofit.create(FakeAPIAuthClient.class).login(userlogin).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                assert response.errorBody() != null;
                return response.errorBody().string();
            }
        });

        new Thread(future).start();

        Map<String, Object> result = new HashMap<>();
        try {
            Object val = future.get();
            if(val instanceof String){
                result.put("code", 401);
                result.put("error", val);
            }else{
                result.put("code", 200);
                result.put("token", val);
            }
        } catch (Exception e) {
            result.put("code", 500);
            result.put("error", "Hubo un error");
        }
        return result;
    }
}
