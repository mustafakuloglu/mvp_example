package com.greendao.mustafa.mvpexample.main;


import com.greendao.mustafa.mvpexample.model.NoteModel;

import java.util.List;

public interface MainActivityView {
    void startAddNoteActivity();

    void fillList(List<NoteModel> noteList);
}
