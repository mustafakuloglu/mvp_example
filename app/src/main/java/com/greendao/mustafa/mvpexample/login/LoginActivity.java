package com.greendao.mustafa.mvpexample.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.greendao.mustafa.mvpexample.R;
import com.greendao.mustafa.mvpexample.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginActivityView {
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_username)
    EditText edtUserName;
    @BindView(R.id.chck_remember_me)
    CheckBox rememberMe;

    LoginActivityPresenter presenter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginActivityPresenterImpl(this);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        presenter.isRemember(sharedPreferences);
    }


    @OnClick(R.id.btn_login)
    public void onclick() {
        presenter.login(edtUserName.getText().toString(), edtPassword.getText().toString(), rememberMe.isChecked(), sharedPreferences);
    }


    @Override
    public void onFailed(String failed) {
        Toast.makeText(this, failed, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSucces() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void isRemember(String username, String password) {
        edtUserName.setText(username);
        edtPassword.setText(password);
        rememberMe.setChecked(true);
    }

}
