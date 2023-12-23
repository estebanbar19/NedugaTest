package com.test.nedugatest.domain;

import android.content.Context;

import com.test.nedugatest.data.ProductsRepository;
import com.test.nedugatest.domain.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class GetProductsUseCase {
    private static ProductsRepository repository = new ProductsRepository();

    public static List<Product> getProducts(Context context){
        List<Product> products = repository.getProductsFromApi();
        if(products.isEmpty() || !internetIsConnected()){
            products = repository.getProductsFromDatabase(context);
        }else{
            repository.clearProducts(context);
            repository.insertProducts(products.stream().map(Product::toEntity).collect(Collectors.toList()), context);
        }
        return products;
    }

    public static boolean internetIsConnected() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);
        } catch (Exception e) {
            return false;
        }
    }

}
