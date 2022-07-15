package ru.timcock.mayday.data.db;

import android.content.Context;

import java.util.ArrayList;

import ru.timcock.mayday.data.Dream;
import ru.timcock.mayday.data.Goal;
import ru.timcock.mayday.data.Note;
import ru.timcock.mayday.data.Some;
import ru.timcock.mayday.data.Task;

public class Tags {
    public static ArrayList<Some> searchTag(String tag, Context context) {
        ArrayList<Some> res = new ArrayList<>(0);
        for (Dream a : new DreamDB(context).selectAll())
            if (a.getDream_tags().contains(tag + " ") || a.getDream_tags().contains(" " + tag))
                res.add(a);
        for (Goal b : new GoalDB(context).selectAll())
            if (b.getGoal_tags().contains(tag + " ") || b.getGoal_tags().contains(" " + tag))
                res.add(b);
        for (Note c : new NoteDB(context).selectAll())
            if (c.getNote_tags().contains(tag + " ") || c.getNote_tags().contains(" " + tag))
                res.add(c);
        for (Task d : new TasksDB(context).selectAll())
            if (d.getTask_tags().contains(tag + " ") || d.getTask_tags().contains(" " + tag))
                res.add(d);
        return res;
    }
}
