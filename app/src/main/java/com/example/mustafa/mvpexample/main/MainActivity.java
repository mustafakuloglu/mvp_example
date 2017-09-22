package com.example.mustafa.mvpexample.main;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mustafa.mvpexample.R;
import com.example.mustafa.mvpexample.model.NoteModel;
import com.example.mustafa.mvpexample.note.NoteActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private List<NoteModel> noteList= new ArrayList<>();
    private RecyclerView recyclerView;
    private MainActivityAdapter mAdapter;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteModel model=new NoteModel("This is title","This is body. This guys is awesome. So blakbslkvşsadmvşsdajvşsdvşs nş");
        noteList.add(model);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter= new MainActivityAdapter(noteList,this);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        presenter= new MainActivityPresenterImpl(this);

        fillLiist();
    }

    @OnClick(R.id.myFAB)
    public void onCick()
    {
presenter.addNote();
    }

    private void fillLiist() {
        for(int i=0;i<20;i++)
        {
            NoteModel model=new NoteModel("This is title"+i,"This is body. This guys is awesome. So blakbslkvşsadmvşsdajvşsdvşs nş"+i);
        noteList.add(model);
        }
    }

    @Override
    public void startAddNoteActivity() {
Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

}
