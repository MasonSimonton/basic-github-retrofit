package com.example.retrofitlastattempt;

import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static String text;
    private static final Api api = Api.retrofit.create(Api.class);
    private Call<List<UserModel>> call = api.loadRepositories();

    public static String firstCall(){
        api.loadRepositories().clone().enqueue(new Callback<List<UserModel>>(){
            @Override
            public void onResponse(@NotNull Call<List<UserModel>> call, @NotNull Response<List<UserModel>> response){
                List<UserModel> repos = response.body();
                if (response != null){
                    int index = (int) (Math.random() * repos.size());
                    //int index = 1;
                    text = "Random repo - " + repos.get(index).getName();

                }
                else{
                    text = "Empty Response";
                }
            }
            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                text = "Request Failed";
                Log.e("RequestCall", "Request failed");
            }
        });
        return text;
    }

    public static String secondCall(int i){
        api.loadRepo(i).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NotNull Call<UserModel> call, @NotNull Response<UserModel> response){
                if(response.body() != null) {
                    UserModel repos = response.body();
                    text = "specific repo - " + repos.getName();

                }
                else{
                    text = "Empty response";
                }
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                text = "Request Failed";
                Log.e("RequestCall", "Request failed");
            }
        });
        return text;
    }

    public static String thirdCall(UserModel model){
        api.newProperty(model).clone().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                secondCall(model.getId());
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                text = "Request Failed";
                Log.e("RequestCall", "Request failed");
            }
        });
        return text;
    }
}
