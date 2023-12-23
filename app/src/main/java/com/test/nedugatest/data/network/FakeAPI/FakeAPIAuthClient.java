package com.test.nedugatest.data.network.FakeAPI;

import com.test.nedugatest.data.models.UserLoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FakeAPIAuthClient {

    @Headers("accept: text/*")
    @POST("/auth/login")
    Call<Object> login(@Body UserLoginModel userData);
}
