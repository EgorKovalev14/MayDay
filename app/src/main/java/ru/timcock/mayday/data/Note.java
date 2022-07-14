package ru.timcock.mayday.data;

import com.google.gson.Gson;

public class Note {
    private String email;
    private Integer id;
    private String text;
    private String text_head;

    public Note() {}

    public Note(String email, Integer id, String text, String text_head) {
        this.email = email;
        this.id = id;
        this.text = text;
        this.text_head = text_head;
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

    public String getText_head() {
        return text_head;
    }

    public void setText_head(String text_head) {
        this.text_head = text_head;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
