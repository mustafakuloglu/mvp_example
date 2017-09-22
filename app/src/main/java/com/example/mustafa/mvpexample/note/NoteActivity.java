package com.example.mustafa.mvpexample.note;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mustafa.mvpexample.R;

public class NoteActivity extends AppCompatActivity implements NoteActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
    }

    @Override
    public void startMainActivity() {

    }
}
