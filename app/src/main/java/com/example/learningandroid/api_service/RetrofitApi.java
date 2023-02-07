package com.example.learningandroid.api_service;

import com.example.learningandroid.models.DataModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitApi {

    @POST("users")
    Call<DataModel> createPost(@Body DataModel dataModal);
}
