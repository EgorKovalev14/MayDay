package ru.timcock.mayday.data.db;

import android.content.Context;

import java.util.ArrayList;

import ru.timcock.mayday.data.Dream;
import ru.timcock.mayday.data.Goal;
import ru.timcock.mayday.data.Note;
import ru.timcock.mayday.data.Some;
import ru.timcock.mayday.data.Task;

public class Tags {
    public static ArrayList<Dream> searchDreams(String tag, Context context) {
        ArrayList<Dream> res = new ArrayList<>(0);
        for (Dream a : new DreamDB(context).selectAll())
            if (a.getDream_tags().contains(tag))
                res.add(a);
        return res;
    }

    public static ArrayList<Goal> searchGoals(String tag, Context context) {
        ArrayList<Goal> res = new ArrayList<>(0);
        for (Goal b : new GoalDB(context).selectAll())
            if (b.getGoal_tags().contains(tag))
                res.add(b);
        return res;
    }

    public static ArrayList<Note> searchNotes(String tag, Context context) {
        ArrayList<Note> res = new ArrayList<>(0);
        for (Note c : new NoteDB(context).selectAll())
            if (c.getNote_tags().contains(tag))
                res.add(c);
        return res;
    }

    public static ArrayList<Task> searchTasks(String tag, Context context) {
        ArrayList<Task> res = new ArrayList<>(0);
        for (Task d : new TasksDB(context).selectAll())
            if (d.getTask_tags().contains(tag))
                res.add(d);
        return res;
    }
}
