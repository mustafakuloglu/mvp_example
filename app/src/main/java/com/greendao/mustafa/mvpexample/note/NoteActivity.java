package com.greendao.mustafa.mvpexample.note;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.greendao.mustafa.mvpexample.NoteApp;
import com.greendao.mustafa.mvpexample.R;
import com.greendao.mustafa.mvpexample.main.MainActivity;
import com.greendao.mustafa.mvpexample.model.DaoSession;
import com.greendao.mustafa.mvpexample.model.NoteModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NoteActivity extends AppCompatActivity implements NoteActivityView {
    @BindView(R.id.edt_title)
    EditText title;
    @BindView(R.id.edt_note)
    EditText body;
    NoteActivityPresenter presenter;

    NoteModel note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        DaoSession daoSession = ((NoteApp) getApplication()).getDaoSession();
        presenter = new NoteActivityPresenterImpl(this, daoSession);

        ButterKnife.bind(this);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            note = (NoteModel) data.getParcelable("Note");
            setNote(note);
        } else {
            note = new NoteModel("", "");
        }
    }



    @OnClick(R.id.btn_ok)
    public void click() {
        note.setTitle(title.getText().toString());
        note.setBody(body.getText().toString());
        presenter.addOrUpdateNote(note);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    public void setNote(NoteModel note) {
        title.setText(note.getTitle());
        body.setText(note.getBody());
    }

}
