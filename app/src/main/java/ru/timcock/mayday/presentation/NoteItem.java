package ru.timcock.mayday.presentation;

import java.io.Serializable;
import java.util.ArrayList;

public class NoteItem implements Serializable {
    String name;
    String date;
    String description;
    ArrayList<String> tags;

    public NoteItem(String name, String date, String description, ArrayList<String> tags) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
