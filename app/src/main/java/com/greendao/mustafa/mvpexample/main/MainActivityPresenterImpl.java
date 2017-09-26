package com.greendao.mustafa.mvpexample.main;


import com.greendao.mustafa.mvpexample.model.DaoSession;
import com.greendao.mustafa.mvpexample.model.NoteModel;
import com.greendao.mustafa.mvpexample.model.NoteModelDao;

import java.util.List;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    DaoSession daoSession;
    NoteModelDao noteDao;
    private MainActivityView view;
    private List<NoteModel> notelist;

    public MainActivityPresenterImpl(MainActivityView view, DaoSession daoSession) {
        this.view = view;
        this.daoSession = daoSession;
    }

    @Override
    public void addNote() {
        view.startAddNoteActivity();
    }

    @Override
    public void fillList() {
        noteDao = daoSession.getNoteModelDao();
        notelist = noteDao.loadAll();
        view.fillList(notelist);
    }
}
