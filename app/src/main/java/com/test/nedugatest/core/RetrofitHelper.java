package com.test.nedugatest.core;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if(retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                    .build();
            retrofit = new Retrofit.Builder().baseUrl("https://fakestoreapi.com").addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        }
        return retrofit;
    }
}
