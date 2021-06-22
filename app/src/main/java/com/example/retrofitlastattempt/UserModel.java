package com.example.retrofitlastattempt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    //@SerializedName("id")
    //@Expose
    //private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;

    public UserModel(){}

    public UserModel(int id, String name, String desc) {
        //this.id = id;
        this.name = name;
        this.description = desc;
    }

    public UserModel(String name, String desc){
        this.name = name;
        this.description = desc;
    }

    public UserModel(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    //public int getId(){
        //return id;
   // }

    public void setName(String name){
        this.name = name;
    }

    //public void setId(int id){
    //    this.id = id;
    //}

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }
}
