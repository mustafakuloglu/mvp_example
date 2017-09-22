package com.example.mustafa.mvpexample.service;


import com.example.mustafa.mvpexample.model.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginService {
    @GET("/Login")
    Call<UserModel> getAnswers(@Query("username") String username,@Query("password") String password);
}
