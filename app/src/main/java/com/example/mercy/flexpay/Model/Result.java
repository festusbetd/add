package com.example.mercy.flexpay.Model;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("errors")
    private String errors;
    @SerializedName("success")
    private Boolean success;
    @SerializedName("data")
    private User data;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("confirm_password")
    private String confirm_password;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("phone_number_1")
    private String phone_number_1;

    public Result(String errors, Boolean success, User data, String username, String email, String password, String confirm_password, String first_name, String last_name, String phone_number_1) {
        this.errors = errors;
        this.success = success;
        this.data = data;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number_1 = phone_number_1;
    }

    public String getErrors() {
        return errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public User getData() {
        return data;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number_1() {
        return phone_number_1;
    }
}
