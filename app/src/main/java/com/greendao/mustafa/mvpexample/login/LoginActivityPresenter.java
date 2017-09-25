package com.greendao.mustafa.mvpexample.login;


import android.content.SharedPreferences;

interface LoginActivityPresenter {
    void login(String username, String password, boolean remember, SharedPreferences sharedPreferences);

    void isRemember(SharedPreferences sharedPreferences);
}
