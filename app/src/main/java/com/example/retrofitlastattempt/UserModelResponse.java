package com.example.retrofitlastattempt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModelResponse {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserModelResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public UserModelResponse withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public UserModelResponse withSecondname(String secondname) {
        this.secondname = secondname;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public UserModelResponse withDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserModelResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getPaygrade() {
        return paygrade;
    }

    public void setPaygrade(String paygrade) {
        this.paygrade = paygrade;
    }

    public UserModelResponse withPaygrade(String paygrade) {
        this.paygrade = paygrade;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public UserModelResponse withDepartment(String department) {
        this.department = department;
        return this;
    }

}
