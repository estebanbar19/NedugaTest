package com.test.nedugatest.data.network.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.test.nedugatest.data.network.Database.Dao.ProductDAO;
import com.test.nedugatest.data.network.Database.Entity.ProductEntity;

@TypeConverters(DatabaseConverter.class)
@Database(entities = {ProductEntity.class}, version = 1)
public abstract class RoomProductsDatabase extends RoomDatabase {

    public static RoomProductsDatabase instance;

    public abstract ProductDAO productDAO();

    public static RoomProductsDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, RoomProductsDatabase.class, "products.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    @Override
    public void clearAllTables() {

    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(@NonNull DatabaseConfiguration databaseConfiguration) {
        return null;
    }
}
