package com.test.nedugatest.ui.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.nedugatest.domain.GetProductsUseCase;
import com.test.nedugatest.domain.model.Product;

import java.util.List;

public class ProductViewModel extends ViewModel {

    public final MutableLiveData<List<Product>> products = new MutableLiveData<>();
    public final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public void onCreate(Context context){
        isLoading.postValue(true);
        List<Product> productModels = GetProductsUseCase.getProducts(context);
        if(productModels != null && !productModels.isEmpty()){
            products.postValue(productModels);
        }
        isLoading.postValue(false);
    }

    public void getAllProducts(Context context) {
        isLoading.postValue(true);
        List<Product> productsModels = GetProductsUseCase.getProducts(context);
        if(productsModels != null && productsModels.isEmpty()){
            products.postValue(productsModels);
        }
        isLoading.postValue(false);
    }
}
