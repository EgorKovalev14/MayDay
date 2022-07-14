package ru.timcock.mayday.data;

import com.google.gson.Gson;

public class Task {
    private String user_email;
    private String task_name;
    private String task_descr;
    private String task_start_dt;
    private String taske_end_dt;
    private String task_tags;

    public Task() {}

    public Task(String user_email, String task_name, String task_descr, String task_start_dt, String taske_end_dt, String task_tags) {
        this.user_email = user_email;
        this.task_name = task_name;
        this.task_descr = task_descr;
        this.task_start_dt = task_start_dt;
        this.taske_end_dt = taske_end_dt;
        this.task_tags = task_tags;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_descr() {
        return task_descr;
    }

    public void setTask_descr(String task_descr) {
        this.task_descr = task_descr;
    }

    public String getTask_start_dt() {
        return task_start_dt;
    }

    public void setTask_start_dt(String task_start_dt) {
        this.task_start_dt = task_start_dt;
    }

    public String getTaske_end_dt() {
        return taske_end_dt;
    }

    public void setTaske_end_dt(String taske_end_dt) {
        this.taske_end_dt = taske_end_dt;
    }

    public String getTask_tags() {
        return task_tags;
    }

    public void setTask_tags(String task_tags) {
        this.task_tags = task_tags;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
