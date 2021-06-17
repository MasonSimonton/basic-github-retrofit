package com.example.retrofitlastattempt;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Api {
    @GET("/properties")
    Call<List<UserModel>> loadRepositories(
            //@Path("user") String user
    );

    @GET("/properties")
    Call<UserModel> loadRepo(
           // @Path("user") String user,
            @Query("id") int id
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pcatease.mocklab.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
