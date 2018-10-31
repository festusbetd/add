package com.example.mercy.flexpay.Model;

import com.google.gson.annotations.SerializedName;

public class APIError {
    @SerializedName("status_code")
    private String status_code;
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

    public APIError() {
    }

    public String Status_code() {
        return status_code;
    }

    public String Errors() {
        return errors;
    }

    public Boolean Success() {
        return success;
    }

    public User Data() {
        return data;
    }

    public String Username() {
        return username;
    }

    public String Email() {
        return email;
    }

    public String Password() {
        return password;
    }

    public String Confirm_password() {
        return confirm_password;
    }

    public String First_name() {
        return first_name;
    }

    public String Last_name() {
        return last_name;
    }

    public String Phone_number_1() {
        return phone_number_1;
    }
}
