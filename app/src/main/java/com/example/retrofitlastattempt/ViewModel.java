package com.example.retrofitlastattempt;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {
    private Repository repository;
    private LiveData<PropertyModel> userModelLiveData;

    public ViewModel(Application application){ super(); }

    public ViewModel(){ super(); }

    public void init(){
        repository = new Repository();

    }


}
