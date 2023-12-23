package com.test.nedugatest.data.models;

import com.google.gson.annotations.SerializedName;

public class UserLoginModel {
    @SerializedName("username")
    private String email;
    @SerializedName("password")
    private String password;

    public UserLoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{\"email\": \""+email+"\", \"password\": \""+password+"\"}";
    }
}
