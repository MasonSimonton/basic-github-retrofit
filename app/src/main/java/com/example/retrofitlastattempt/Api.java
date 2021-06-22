package com.example.retrofitlastattempt;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface Api {


    @GET("/properties")
    Call<List<UserModel>> loadRepositories(
            //@Path("user") String user
    );

    @GET("/properties/{id}")
    Call<UserModel> loadRepo(
           // @Path("user") String user,
            @Path("id") int id
    );

    @POST("/properties")
    Call<UserModel> newProperty(
            @Body UserModel property
    );

    //Mock lab "https://pcatease.mocklab.io"
    //ruby Rails "https://whispering-depths-34644.herokuapp.com/"
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://whispering-depths-34644.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
