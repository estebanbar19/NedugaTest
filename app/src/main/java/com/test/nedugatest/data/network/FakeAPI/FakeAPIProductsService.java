package com.test.nedugatest.data.network.FakeAPI;

import com.test.nedugatest.core.RetrofitHelper;
import com.test.nedugatest.data.models.ProductModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

import retrofit2.Response;
import retrofit2.Retrofit;

public class FakeAPIProductsService {
    private Retrofit retrofit = RetrofitHelper.getRetrofit();

    public List<ProductModel> getProducts(){
        FutureTask<List<ProductModel>> future = new FutureTask<>(() -> {
            Response<List<ProductModel>> response = retrofit.create(FakeAPIProductsClient.class).getProducts().execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Failed to get products: " + response.message());
            }
        });

        new Thread(future).start();

        try {
            return future.get();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
