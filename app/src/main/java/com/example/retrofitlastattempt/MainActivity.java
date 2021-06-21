package com.example.retrofitlastattempt;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String text;
    private int loadedRepo = 12;
    private final Api api = Api.retrofit.create(Api.class);
    private String name = "Mason's Crib";
    private int id = 12;
    private String desc = "Just a testing property";
    UserModel model = new UserModel(name, id, desc);
    private Call<List<UserModel>> call = api.loadRepositories();
    private Call<UserModel> call2 = api.loadRepo(loadedRepo);
    private Call<UserModel> call3 = api.newProperty(model);
    TextView textView;
    EditText textName;
    EditText textId;
    EditText textDesc;
    Button button;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        textName = (EditText) findViewById(R.id.text_name);
        textId = (EditText) findViewById(R.id.text_id);
        textDesc = (EditText) findViewById(R.id.text_desc);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //textView.setText("Loading random repo...");
                textView.setText(Repository.firstCall());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Loading specific repo...");
                text = Repository.secondCall(id);
                textView.setText(text);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("creating new property...");
                //name = textName.getText().toString();
                //id = 12;
                //desc = textDesc.getText().toString();
                if(name != "" && desc != "") {
                    model = new UserModel(name, id, desc);
                    text = Repository.thirdCall(model);
                    textView.setText(text);
                }
                else textView.setText("need name AND description");
            }
        });
    }

    public void firstCall(){
        call.clone().enqueue(new Callback<List<UserModel>>(){
            @Override
            public void onResponse(@NotNull Call<List<UserModel>> call, @NotNull Response<List<UserModel>> response){
                List<UserModel> repos = response.body();
                if (response != null){
                    int index = (int) (Math.random() * repos.size());
                    //int index = 1;
                    String text = "Random repo - " + repos.get(index).getName();
                    textView.setText(text);
                }
                else{
                    textView.setText("Empty Response");
                }
            }
            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                textView.setText("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public void secondCall(int i){
        api.loadRepo(i).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NotNull Call<UserModel> call, @NotNull Response<UserModel> response){
                if(response.body() != null) {
                    UserModel repos = response.body();
                    String text = "specific repo - " + repos.getName();
                    textView.setText(text);
                }
                else{
                    textView.setText("Empty response");
                }
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                textView.setText("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }

    public void thirdCall(){
        call3.clone().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                secondCall(id);
            }
            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                textView.setText("Request Failed");
                Log.e("RequestCall", "Request failed");
            }
        });
    }
}