package ru.timcock.mayday.data;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

public class Goal {
    private String email;
    private Integer it;
    private String tag;
    private String data_time;
    private String end_date;

    public Goal() {}

    public Goal(String email, Integer it, String tag, String data_time, String end_date) {
        this.email = email;
        this.it = it;
        this.tag = tag;
        this.data_time = data_time;
        this.end_date = end_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIt() {
        return it;
    }

    public void setIt(Integer it) {
        this.it = it;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
