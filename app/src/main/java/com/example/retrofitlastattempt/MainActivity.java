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

    private final Api api = Api.retrofit.create(Api.class);
    private String name = "Mason's Crib";
    private int id = 7;
    private int loadedRepo = 1;
    private String desc = "A basic testing property";
    UserModel model = new UserModel(name, id, desc);
    private Call<List<UserModel>> call = api.loadRepositories();
    //private Call<UserModel> call2 = api.loadRepo(id);
    private Call<UserModel> call3 = api.newProperty(model);
    private List<UserModel> mockModels;
    private List<UserModel> userModels;
    static TextView textView;
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

        /*
          each button calls a different Retrofit request.
          1: gets list of java objects and picks random one
          2: selects a specific
          3:
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Loading random repo...");
                Repository.firstCall();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Loading specific repo...");
                Repository.secondCall(loadedRepo);
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
                    Repository.thirdCall(model);
                }
                else textView.setText("need name AND description");
            }
        });
    }

    public static void setTextView(String string){
        textView.setText(string);
    }
}