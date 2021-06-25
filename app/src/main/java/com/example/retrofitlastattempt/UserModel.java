package com.example.retrofitlastattempt;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("secondname")
    @Expose
    private String secondname;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("paygrade")
    @Expose
    private String paygrade;
    @SerializedName("department")
    @Expose
    private String department;

    public UserModel(){}

    public UserModel(String firstname, String secondname, String dob, String status, String paygrade, String department){
        this.firstname = firstname;
        this.secondname = secondname;
        this.dob = dob;
        this.status = status;
        this.paygrade = paygrade;
        this.department = department;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaygrade() {
        return paygrade;
    }

    public void setPaygrade(String paygrade) {
        this.paygrade = paygrade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
