package ru.timcock.mayday.data;

import com.google.gson.Gson;

public class Dream implements Some {
    private String user_email;
    private String dream_name;
    private String dream_tags;
    private String dream_dt;
    private String img_text;

    public Dream() {}

    public Dream(String user_email, String dream_name, String dream_tags, String dream_dt, String img_text) {
        this.user_email = user_email;
        this.dream_name = dream_name;
        this.dream_tags = dream_tags;
        this.dream_dt = dream_dt;
        this.img_text = img_text;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getDream_name() {
        return dream_name;
    }

    public void setDream_name(String dream_name) {
        this.dream_name = dream_name;
    }

    public String getDream_tags() {
        return dream_tags;
    }

    public void setDream_tags(String dream_tags) {
        this.dream_tags = dream_tags;
    }

    public String getDream_dt() {
        return dream_dt;
    }

    public void setDream_dt(String dream_dt) {
        this.dream_dt = dream_dt;
    }

    public String getImg_text() {
        return img_text;
    }

    public void setImg_text(String img_text) {
        this.img_text = img_text;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
