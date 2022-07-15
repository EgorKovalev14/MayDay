package ru.timcock.mayday.data;

import com.google.gson.Gson;

public class Goal implements Some {
    private String user_email;
    private String goal_tags;
    private String data_time;
    private String goal_end_dt;
    private String goal_start_dt;
    private String goal_success;
    private String goal_descr;
    private String goal_name;

    public Goal() {}

    public Goal(String user_email, String goal_tags, String data_time, String goal_end_dt, String goal_start_dt, String goal_success, String goal_descr, String goal_name) {
        this.user_email = user_email;
        this.goal_tags = goal_tags;
        this.data_time = data_time;
        this.goal_end_dt = goal_end_dt;
        this.goal_start_dt = goal_start_dt;
        this.goal_success = goal_success;
        this.goal_descr = goal_descr;
        this.goal_name = goal_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getGoal_tags() {
        return goal_tags;
    }

    public void setGoal_tags(String goal_tags) {
        this.goal_tags = goal_tags;
    }

    public String getData_time() {
        return data_time;
    }

    public void setData_time(String data_time) {
        this.data_time = data_time;
    }

    public String getGoal_end_dt() {
        return goal_end_dt;
    }

    public void setGoal_end_dt(String goal_end_dt) {
        this.goal_end_dt = goal_end_dt;
    }

    public String getGoal_start_dt() {
        return goal_start_dt;
    }

    public void setGoal_start_dt(String goal_start_dt) {
        this.goal_start_dt = goal_start_dt;
    }

    public String getGoal_success() {
        return goal_success;
    }

    public void setGoal_success(String goal_success) {
        this.goal_success = goal_success;
    }

    public String getGoal_descr() {
        return goal_descr;
    }

    public void setGoal_descr(String goal_descr) {
        this.goal_descr = goal_descr;
    }

    public String getGoal_name() {
        return goal_name;
    }

    public void setGoal_name(String goal_name) {
        this.goal_name = goal_name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
