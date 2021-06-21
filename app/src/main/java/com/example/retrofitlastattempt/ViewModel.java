package com.example.retrofitlastattempt;

import android.app.Application;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private Repository repository;
    private LiveData<UserModel> userModelLiveData;

    public ViewModel(Application application){ super(); }

    public ViewModel(){ super(); }

    public void init(){
        repository = new Repository();

    }


}
