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
    private String firstname = "Mason";
    private String secondname = "Simonton";
    private String dob = "1997-12-31";
    private String status = "Stupid";
    private String paygrade = "hahahahaha";
    private String department = "computers or something";
    PropertyModel model = new PropertyModel(name, desc);
    UserModel userModel = new UserModel(firstname, secondname, dob, status, paygrade, department);
    private Call<List<PropertyModel>> call = api.loadRepositories();
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
        Button button5 = (Button) findViewById(R.id.button5);

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
                //Repository.randomProperty();
                Repository.randomUser();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Loading specific repo...");

                Repository.specificProperty(loadedRepo);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("creating new property...");
                name = textName.getText().toString();
                desc = textDesc.getText().toString();
                if(name.isEmpty() == false & desc.isEmpty() == false) {
                    model = new PropertyModel(name, desc);
                    Repository.newProperty(model);
                }
                else textView.setText("need name AND description");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Repository.lastProperty();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Repository.randomProperty();
            }
        });
    }

    public static void setTextView(String string){
        textView.setText(string);
    }
}