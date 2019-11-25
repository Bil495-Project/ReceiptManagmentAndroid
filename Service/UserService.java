package com.example.proje.Service;

import com.example.proje.Model.UserModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {
    @GET("books")
    Call<List<UserModel>> all();

    @GET("books/{isbn}")
    Call<UserModel> get(@Path("") String user);

    @POST("books/new")
    Call<UserModel> create(@Body UserModel user);
}