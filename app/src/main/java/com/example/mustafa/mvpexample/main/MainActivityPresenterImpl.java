package com.example.mustafa.mvpexample.main;


public class MainActivityPresenterImpl implements MainActivityPresenter{

    private MainActivityView view;
    public MainActivityPresenterImpl(MainActivityView view) {
    this.view=view;
    }

    @Override
    public void addNote() {
view.startAddNoteActivity();
    }
}
