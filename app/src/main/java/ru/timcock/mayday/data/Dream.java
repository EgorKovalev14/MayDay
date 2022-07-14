package ru.timcock.mayday.data;

import com.google.gson.Gson;

public class Dream {
    private String email;
    private Integer id;
    private String text;
    private String data_time;
    private String img;

    public Dream() {}

    public Dream(String email, Integer id, String text, String data_time, String img) {
        this.email = email;
        this.id = id;
        this.text = text;
        this.data_time = data_time;
        this.img = img;
    }

    public Dream(String email, String text, String data_time, String img) {
        this.email = email;
        this.text = text;
        this.data_time = data_time;
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
