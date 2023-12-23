package com.test.nedugatest.data.network.Database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.test.nedugatest.data.models.RatingModel;

public class DatabaseConverter {

    @TypeConverter
    public String fromRating(RatingModel rating){
        return rating.toString();
    }

    @TypeConverter
    public RatingModel toRating(String rating){
        Gson gson = new Gson();
        return gson.fromJson(rating, RatingModel.class);
    }
}
