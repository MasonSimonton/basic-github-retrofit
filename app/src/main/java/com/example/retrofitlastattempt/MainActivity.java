package com.example.retrofitlastattempt;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private final Api api = Api.retrofit.create(Api.class);
    private String name = "Evil Lair";
    private int id = 7;
    private int loadedRepo = 1;
    private String desc = "A basic testing property";
    PropertyModel model = new PropertyModel(name, desc);
    private Call<List<PropertyModel>> call = api.loadRepositories();
    //private Call<UserModel> call2 = api.loadRepo(id);
    //private Call<UserModel> call3 = api.newProperty(model);
    //private List<UserModel> userModels;
    static TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        EditText textName = (EditText) findViewById(R.id.text_name);
        EditText textId = (EditText) findViewById(R.id.text_id);
        EditText textDesc = (EditText) findViewById(R.id.text_desc);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);

        /*
          each button calls a different Retrofit request.
          1: gets list of java objects and picks random one
          2: selects a specific property based on id
          3: creates a whole new property
          4: gets last property in list
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
                //if(name != "" && desc != "") {
                    //model = new PropertyModel(name, desc);
                    Repository.thirdCall(model);
                //}
                //else textView.setText("need name AND description");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Repository.fourthCall();
            }
        });
    }

    public static void setTextView(String string){
        textView.setText(string);
    }
}