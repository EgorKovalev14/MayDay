package ru.timcock.mayday.data;

import com.google.gson.Gson;

public class Note {
    private String user_email;
    private String note_name;
    private String note_descr;
    private String note_img;
    private String note_dt;
    private String note_tags;

    public Note() {}

    public Note(String user_email, String note_name, String note_descr, String note_img, String note_dt, String note_tags) {
        this.user_email = user_email;
        this.note_name = note_name;
        this.note_descr = note_descr;
        this.note_img = note_img;
        this.note_dt = note_dt;
        this.note_tags = note_tags;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getNote_name() {
        return note_name;
    }

    public void setNote_name(String note_name) {
        this.note_name = note_name;
    }

    public String getNote_descr() {
        return note_descr;
    }

    public void setNote_descr(String note_descr) {
        this.note_descr = note_descr;
    }

    public String getNote_img() {
        return note_img;
    }

    public void setNote_img(String note_img) {
        this.note_img = note_img;
    }

    public String getNote_dt() {
        return note_dt;
    }

    public void setNote_dt(String note_dt) {
        this.note_dt = note_dt;
    }

    public String getNote_tags() {
        return note_tags;
    }

    public void setNote_tags(String note_tags) {
        this.note_tags = note_tags;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
