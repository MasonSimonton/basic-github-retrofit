package com.example.retrofitlastattempt;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final Api api = Api.retrofit.create(Api.class);
    private Call<List<UserModel>> call = api.loadRepositories("masonsimonton");

     //call.enqueue(new CallBack<List<UserModel>>(){
       //@Override
       //public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response){

        //}
    //});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.textview);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Loading random repo...");
                api.loadRepositories("masonsimonton").enqueue(new Callback<List<UserModel>>(){
                    @Override
                    public void onResponse(@NotNull Call<List<UserModel>> call, @NotNull Response<List<UserModel>> response){
                        List<UserModel> repos = response.body();

                        int index = (int) (Math.random() * repos.size());
                        String text = "Random repo - " + repos.get(index).getUser();
                        textView.setText(text);
                    }

                    @Override
                    public void onFailure(Call<List<UserModel>> call, Throwable t) {
                        textView.setText("Request Failed");
                        Log.e("RequestCall", "Request failed");
                    }
                });
            }
        });


    }
}