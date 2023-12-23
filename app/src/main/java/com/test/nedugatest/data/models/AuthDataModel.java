package com.test.nedugatest.data.models;

public class AuthDataModel {
    private String token;

    public AuthDataModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
