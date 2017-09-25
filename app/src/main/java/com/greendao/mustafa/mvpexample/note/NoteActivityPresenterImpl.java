package com.greendao.mustafa.mvpexample.note;

import com.greendao.mustafa.mvpexample.NoteApp;
import com.greendao.mustafa.mvpexample.model.DaoSession;
import com.greendao.mustafa.mvpexample.model.NoteModel;
import com.greendao.mustafa.mvpexample.model.NoteModelDao;

/**
 * Created by mustafa on 22.09.2017.
 */

public class NoteActivityPresenterImpl implements NoteActivityPresenter {
    NoteActivityView view;
    NoteModelDao noteDao;

    public NoteActivityPresenterImpl(NoteActivity view) {
        this.view = view;
        DaoSession daoSession = ((NoteApp) view.getApplication()).getDaoSession();
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
