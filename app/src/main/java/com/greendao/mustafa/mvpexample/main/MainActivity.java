package com.greendao.mustafa.mvpexample.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.greendao.mustafa.mvpexample.NoteApp;
import com.greendao.mustafa.mvpexample.R;
import com.greendao.mustafa.mvpexample.model.DaoSession;
import com.greendao.mustafa.mvpexample.model.NoteModel;
import com.greendao.mustafa.mvpexample.model.NoteModelDao;
import com.greendao.mustafa.mvpexample.note.NoteActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    NoteModelDao noteDao;
    private List<NoteModel> noteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MainActivityAdapter mAdapter;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession = ((NoteApp) getApplication()).getDaoSession();
        noteDao = daoSession.getNoteModelDao();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        ButterKnife.bind(this);

        fillLiist();

        mAdapter = new MainActivityAdapter(noteList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        presenter = new MainActivityPresenterImpl(this);


    }


    @OnClick(R.id.myFAB)
    public void onCick() {
        presenter.addNote();
    }

    private void fillLiist() {
        noteList = noteDao.loadAll();
    }

    @Override
    public void startAddNoteActivity() {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.myFAB)
    public void click() {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

}
