package ru.timcock.mayday.data.requests;

public class AddDreamRequest {
    public String user_email;
    public String dream_name;
    public String dream_tags;
    public String dream_dt;
    public String img_text;

    public AddDreamRequest() {}

    public AddDreamRequest(String user_email, String dream_name, String dream_tags, String dream_dt, String img_text) {
        this.user_email = user_email;
        this.dream_name = dream_name;
        this.dream_tags = dream_tags;
        this.dream_dt = dream_dt;
        this.img_text = img_text;
    }
}
