package com.greendao.mustafa.mvpexample;

import android.app.Application;

import com.greendao.mustafa.mvpexample.model.DaoMaster;
import com.greendao.mustafa.mvpexample.model.DaoSession;

import org.greenrobot.greendao.database.Database;


public class NoteApp extends Application {
    public static String BASE_URL = "http://10.17.1.147/";
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes.db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();


    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
