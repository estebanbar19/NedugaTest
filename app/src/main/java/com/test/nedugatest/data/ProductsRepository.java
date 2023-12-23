package com.test.nedugatest.data;

import android.content.Context;

import com.test.nedugatest.data.models.ProductModel;
import com.test.nedugatest.data.network.Database.Entity.ProductEntity;
import com.test.nedugatest.data.network.Database.RoomProductsDatabase;
import com.test.nedugatest.data.network.FakeAPI.FakeAPIProductsService;
import com.test.nedugatest.domain.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsRepository {
    private FakeAPIProductsService api = new FakeAPIProductsService();

    public List<Product> getProductsFromApi(){
        List<ProductModel> products =  api.getProducts();
        return products.stream().map(productModel -> new Product(productModel.getId(), productModel.getTitle(), productModel.getPrice(), productModel.getDescription(), productModel.getCategory(), productModel.getImage(), productModel.getRating())).collect(Collectors.toList());
    }

    public List<Product> getProductsFromDatabase(Context context){
        RoomProductsDatabase database = RoomProductsDatabase.getInstance(context);
        List<ProductEntity> products = database.productDAO().getAllProducts();
        return products.stream().map(productEntity -> new Product(productEntity.getId(), productEntity.getTitle(), productEntity.getPrice(), productEntity.getDescription(), productEntity.getCategory(), productEntity.getImage(),productEntity.getRating())).collect(Collectors.toList());
    }

    public void insertProducts(List<ProductEntity> products, Context context){
        RoomProductsDatabase database = RoomProductsDatabase.getInstance(context);
        for (ProductEntity product:
             products) {
            database.productDAO().insertProduct(product);
        }
    }


    public void clearProducts(Context context){
        RoomProductsDatabase database = RoomProductsDatabase.getInstance(context);
        database.productDAO().removeAllProducts();
    }

}
