
package com.greendao.mustafa.mvpexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("LoginSuccess")
    @Expose
    private String loginSuccess;


    public UserModel() {
    }

    /**
     * @param message
     * @param loginSuccess
     */
    public UserModel(String message, String loginSuccess) {
        super();
        this.message = message;
        this.loginSuccess = loginSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(String loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

}