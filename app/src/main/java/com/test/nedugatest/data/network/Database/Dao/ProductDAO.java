package com.test.nedugatest.data.network.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.test.nedugatest.data.network.Database.Entity.ProductEntity;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM Products")
    List<ProductEntity> getAllProducts();

//    @Query("SELECT * FROM Products")
//    List<ProductEntity> getProducts(int limit);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ProductEntity> products);

    @Insert
    void insertProduct(ProductEntity productEntity);

    @Update
    void updateProduct(ProductEntity productEntity);

    @Delete
    void removeProduct(ProductEntity productEntity);

    @Query("DELETE FROM Products")
    void removeAllProducts();
}
