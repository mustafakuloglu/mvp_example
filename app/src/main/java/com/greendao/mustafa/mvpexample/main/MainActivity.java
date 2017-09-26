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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    NoteModelDao noteDao;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private List<NoteModel> noteList = new ArrayList<>();
    private MainActivityAdapter mAdapter;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession = ((NoteApp) getApplication()).getDaoSession();

        presenter = new MainActivityPresenterImpl(this, daoSession);

        presenter.fillList();

        ButterKnife.bind(this);

        mAdapter = new MainActivityAdapter(noteList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }


    @OnClick(R.id.myFAB)
    public void onCick() {
        presenter.addNote();
    }



    @Override
    public void startAddNoteActivity() {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    @Override
    public void fillList(List<NoteModel> noteList) {
        this.noteList = noteList;
    }

    @OnClick(R.id.myFAB)
    public void click() {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

}
