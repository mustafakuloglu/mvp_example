package com.example.mustafa.mvpexample.login;


import android.content.SharedPreferences;

import com.example.mustafa.mvpexample.model.UserModel;
import com.example.mustafa.mvpexample.service.LoginService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.mustafa.mvpexample.NoteApp.BASE_URL;

class LoginActivityPresenterImpl implements LoginActivityPresenter {

    private LoginActivityView loginView;
    private static Retrofit retrofit = null;
    private SharedPreferences.Editor editor;

    LoginActivityPresenterImpl(LoginActivityView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(final String username, final String password, final boolean remember, final SharedPreferences sharedPreferences) {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginService service = retrofit.create(LoginService.class);

        service.getAnswers(username, password).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if ("true".equals(response.body().getLoginSuccess())) {
                    if (remember) {
                        editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.apply();
                    }
                    loginView.onSucces();
                } else
                    loginView.onFailed("fail");
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                loginView.onFailed(t.getMessage());
            }
        });


    }

    @Override
    public void isRemember(SharedPreferences sharedPreferences) {
        String username = sharedPreferences.getString("username", "N/A");
        String password = sharedPreferences.getString("password", "N/A");
        if (!username.equals("N/A") && !password.equals("N/A"))
            loginView.isRemember(username, password);
    }
}


