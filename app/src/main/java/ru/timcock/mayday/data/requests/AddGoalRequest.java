package ru.timcock.mayday.data.requests;

public class AddGoalRequest {
    public String user_email;
    public String goal_tags;
    public String data_time;
    public String goal_end_dt;
    public String goal_start_dt;
    public String goal_success;
    public String goal_descr;
    public String goal_name;

    public AddGoalRequest() {}

    public AddGoalRequest(String user_email, String goal_tags, String data_time, String goal_end_dt, String goal_start_dt, String goal_success, String goal_descr, String goal_name) {
        this.user_email = user_email;
        this.goal_tags = goal_tags;
        this.data_time = data_time;
        this.goal_end_dt = goal_end_dt;
        this.goal_start_dt = goal_start_dt;
        this.goal_success = goal_success;
        this.goal_descr = goal_descr;
        this.goal_name = goal_name;
    }
}
