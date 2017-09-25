package com.greendao.mustafa.mvpexample.login;

/**
 * Created by mustafa on 22.09.2017.
 */

interface LoginActivityView {

    void onFailed(String failed);

    void onSucces();

    void isRemember(String username, String password);
}
