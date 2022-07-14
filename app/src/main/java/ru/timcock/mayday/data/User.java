package ru.timcock.mayday.data;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

public class User {
    private String name;
    private String email;
    private String it_tg;

    public User() {}

    public User(String name, String email, String it_tg) {
        this.name = name;
        this.email = email;
        this.it_tg = it_tg;
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

    public String getIt_tg() {
        return it_tg;
    }

    public void setIt_tg(String it_tg) {
        this.it_tg = it_tg;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
