package com.example.retrofitlastattempt;

import android.util.Log;
import android.util.LogPrinter;
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
    //private Call<List<UserModel>> call = api.loadRepositories();

    public static void firstCall(){
        api.loadRepositories().clone().enqueue(new Callback<List<UserModel>>(){
            @Override
            public void onResponse(@NotNull Call<List<UserModel>> call, @NotNull Response<List<UserModel>> response){
                List<UserModel> property = response.body();
                if (response != null){
                    int index = (int) (Math.random() * property.size());
                    MainActivity.setTextView( "Random Property - " + property.get(index).getName());
                }
                else{
                    MainActivity.setTextView("Empty Response");
                }
            }
            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public static void secondCall(int i){
        api.loadRepo(i).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NotNull Call<UserModel> call, @NotNull Response<UserModel> response){
                if(response.body() != null) {
                    UserModel property = response.body();
                    MainActivity.setTextView("Specific Property - " + property.getName());
                }
                else{
                    MainActivity.setTextView("Empty response");
                }
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public static void thirdCall(UserModel model){
        api.newProperty(model).clone().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                //secondCall(model.getId());
                Log.e("RequestCall", response.toString());
                MainActivity.setTextView("Complete!");
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public static void fourthCall(){
        api.loadRepositories().clone().enqueue(new Callback<List<UserModel>>(){
            @Override
            public void onResponse(@NotNull Call<List<UserModel>> call, @NotNull Response<List<UserModel>> response){
                List<UserModel> property = response.body();
                if (response != null){
                    int index = property.size() -1;
                    MainActivity.setTextView( "Random Property - " + property.get(index).getName());
                }
                else{
                    MainActivity.setTextView("Empty Response");
                }
            }
            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                MainActivity.setTextView("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }
}
