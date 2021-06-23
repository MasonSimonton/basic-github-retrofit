package com.example.retrofitlastattempt;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static String text;
    private static final Api api = Api.retrofit.create(Api.class);
    //private Call<List<UserModel>> call = api.loadRepositories();

    public static void firstCall(){
        api.loadRepositories().clone().enqueue(new Callback<List<PropertyModel>>(){
            @Override
            public void onResponse(@NotNull Call<List<PropertyModel>> call, @NotNull Response<List<PropertyModel>> response){
                List<PropertyModel> property = response.body();
                if (response.body() != null){
                    int index = (int) (Math.random() * property.size());
                    MainActivity.setTextView( "Random Property - " + property.get(index).getName());
                }
                else{
                    MainActivity.setTextView("Empty Response");
                }
            }
            @Override
            public void onFailure(Call<List<PropertyModel>> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public static void secondCall(int i){
        api.loadRepo(i).enqueue(new Callback<PropertyModel>() {
            @Override
            public void onResponse(@NotNull Call<PropertyModel> call, @NotNull Response<PropertyModel> response){
                if(response.body() != null) {
                    PropertyModel property = response.body();
                    MainActivity.setTextView("Specific Property - " + property.getName());
                }
                else{
                    MainActivity.setTextView("Empty response");
                }
            }
            @Override
            public void onFailure(Call<PropertyModel> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public static void thirdCall(PropertyModel model){
        api.newProperty(model.getName(), model.getDesc(), model.getCreatedAt(), model.getUpdatedAt()).clone().enqueue(new Callback<PropertyModel>() {
            @Override
            public void onResponse(Call<PropertyModel> call, Response<PropertyModel> response) {
                //secondCall(model.getId());
                Log.e("RequestCall", response.toString());
                MainActivity.setTextView("Complete!");
            }
            @Override
            public void onFailure(Call<PropertyModel> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public static void fourthCall(){
        api.loadRepositories().clone().enqueue(new Callback<List<PropertyModel>>(){
            @Override
            public void onResponse(@NotNull Call<List<PropertyModel>> call, @NotNull Response<List<PropertyModel>> response){
                List<PropertyModel> property = response.body();
                if (response.body() != null){
                    int index = property.size() -1;
                    MainActivity.setTextView( "Random Property - " + property.get(index).getName());
                }
                else{
                    MainActivity.setTextView("Empty Response");
                }
            }
            @Override
            public void onFailure(Call<List<PropertyModel>> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }
}
