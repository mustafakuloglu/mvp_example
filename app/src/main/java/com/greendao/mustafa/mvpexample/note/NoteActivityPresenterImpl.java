package com.greendao.mustafa.mvpexample.note;

import com.greendao.mustafa.mvpexample.model.DaoSession;
import com.greendao.mustafa.mvpexample.model.NoteModel;
import com.greendao.mustafa.mvpexample.model.NoteModelDao;

/**
 * Created by mustafa on 22.09.2017.
 */

public class NoteActivityPresenterImpl implements NoteActivityPresenter {
    NoteActivityView view;
    NoteModelDao noteDao;
    DaoSession daoSession;

    public NoteActivityPresenterImpl(NoteActivityView view, DaoSession daoSession) {
        this.view = view;
        this.daoSession = daoSession;
        noteDao = daoSession.getNoteModelDao();
    }


    @Override
    public void addOrUpdateNote(NoteModel note) {
        if (note.getId() == null) {
            noteDao.insert(note);
        } else {
            noteDao.update(note);
        }
    }
}
