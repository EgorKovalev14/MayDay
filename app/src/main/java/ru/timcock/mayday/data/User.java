package ru.timcock.mayday.data;

import com.google.gson.Gson;

public class User {
    private String name;
    private String email;
    private String password;
    private String id_tg;

    public User() {}

    public User(String name, String email, String password, String id_tg) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id_tg = id_tg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId_tg() {
        return id_tg;
    }

    public void setId_tg(String id_tg) {
        this.id_tg = id_tg;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
