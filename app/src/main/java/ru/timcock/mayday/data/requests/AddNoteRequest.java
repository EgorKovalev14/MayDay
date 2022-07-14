package ru.timcock.mayday.data.requests;

public class AddNoteRequest {
    public String user_email;
    public String note_name;
    public String note_descr;
    public String note_img;
    public String note_dt;
    public String note_tags;

    public AddNoteRequest() {}

    public AddNoteRequest(String user_email, String note_name, String note_descr, String note_img, String note_dt, String note_tags) {
        this.user_email = user_email;
        this.note_name = note_name;
        this.note_descr = note_descr;
        this.note_img = note_img;
        this.note_dt = note_dt;
        this.note_tags = note_tags;
    }
}
