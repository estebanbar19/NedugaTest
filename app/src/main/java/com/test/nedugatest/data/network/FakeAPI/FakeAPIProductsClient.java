package com.test.nedugatest.data.network.FakeAPI;

import com.test.nedugatest.data.models.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeAPIProductsClient {

    @GET("/products?limit=20")
    Call<List<ProductModel>> getProducts();
}
