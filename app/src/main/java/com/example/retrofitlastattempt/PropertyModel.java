package com.example.retrofitlastattempt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import java.util.Date;

public class PropertyModel {


    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    private Date date = Calendar.getInstance().getTime();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    public PropertyModel(){}

    public PropertyModel(int id, String name, String desc) {
        //this.id = id;
        this.name = name;
        this.description = desc;
        this.createdAt = getCreatedAt();
        this.updatedAt = getUpdatedAt();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PropertyModel(String name, String description){
        setName(name);
        setDesc(description);
        //createdAt = dateFormat.format(date);
        //updatedAt = dateFormat.format(date);
    }

    public PropertyModel(String name){
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
