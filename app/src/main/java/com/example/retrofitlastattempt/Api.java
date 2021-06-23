package com.example.retrofitlastattempt;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface Api {

    //How to current date/time: JSON.stringify({'now': new Date()}); ends up generating "{"now":"2013-10-21T13:28:06.419Z"}" – Steven Oct 21 '13 at 13:28

    @GET("/properties")
    Call<List<PropertyModel>> loadRepositories(
            //@Path("user") String user
    );

    @GET("/properties/{id}")
    Call<PropertyModel> loadRepo(
           // @Path("user") String user,
            @Path("id") int id
    );

    @FormUrlEncoded
    @POST("/properties")
    Call<PropertyModel> newProperty(
            //@Body PropertyModel model
            @Field("name") String name,
            @Field("description") String desc,
            @Field("created_at") String created_at,
            @Field("updated_at") String updated_at

    );

    @POST("/users")
    Call<UserModel> newUser(
            @Body UserModel model
    );

    //Mock lab "https://pcatease.mocklab.io"
    //ruby Rails "https://whispering-depths-34644.herokuapp.com/"
    //new ruby rails "https://at-ease-api-test.herokuapp.com/"
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://at-ease-api-test.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
