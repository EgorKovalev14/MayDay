package ru.timcock.mayday.data.requests;

public class AddTaskRequest {
    public String user_email;
    public String task_name;
    public String task_descr;
    public String task_start_dt;
    public String taske_end_dt;
    public String task_tags;

    public AddTaskRequest() {}

    public AddTaskRequest(String user_email, String task_name, String task_descr, String task_start_dt, String taske_end_dt, String task_tags) {
        this.user_email = user_email;
        this.task_name = task_name;
        this.task_descr = task_descr;
        this.task_start_dt = task_start_dt;
        this.taske_end_dt = taske_end_dt;
        this.task_tags = task_tags;
    }
}
