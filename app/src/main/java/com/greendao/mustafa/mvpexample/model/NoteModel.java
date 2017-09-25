package com.greendao.mustafa.mvpexample.model;


import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;

@Entity
public class NoteModel implements Parcelable {
    public static final Creator<NoteModel> CREATOR = new Creator<NoteModel>() {
        @Override
        public NoteModel createFromParcel(Parcel in) {
            return new NoteModel(in);
        }

        @Override
        public NoteModel[] newArray(int size) {
            return new NoteModel[size];
        }
    };
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String body;
    private Date createDate;

    public NoteModel(String title, String body) {
        this.title = title;
        this.body = body;
    }

    protected NoteModel(Parcel in) {
        id = in.readLong();
        title = in.readString();
        body = in.readString();
    }

    @Generated(hash = 1746289381)
    public NoteModel(Long id, String title, String body, Date createDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createDate = createDate;
    }

    @Generated(hash = 1532285157)
    public NoteModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(title);
        parcel.writeString(body);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
