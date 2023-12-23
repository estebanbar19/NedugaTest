package com.test.nedugatest.data;

import com.test.nedugatest.data.network.FakeAPI.FakeAPIAuthService;

import java.util.Map;

public class AuthRepository {
    private FakeAPIAuthService api = new FakeAPIAuthService();

    public Map<String, Object> SignInWithApi(String email, String password){
        return api.signIn(email, password);
    }

}
