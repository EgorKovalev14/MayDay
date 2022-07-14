package ru.timcock.mayday.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import ru.timcock.mayday.data.Task;

public class TasksDB {
    private static final String DATABASE_NAME = "task.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tasks";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCR = "descr";
    public static final String COLUMN_START_DT = "start_dt";
    public static final String COLUMN_END_DT = "end_dt";
    public static final String COLUMN_TAGS = "tags";
    public static final Integer NUM_COLUMN_NAME = 0;
    public static final Integer NUM_COLUMN_DESCR = 1;
    public static final Integer NUM_COLUMN_START_DT = 2;
    public static final Integer NUM_COLUMN_END_DT = 3;
    public static final Integer NUM_COLUMN_TAGS = 4;
    public static final Integer NUM_COLUMN_EMAIL = 5;
    private SQLiteDatabase dataBase;

    public TasksDB(Context context) {
        TasksDB.OpenHelper openHelper = new TasksDB.OpenHelper(context);
        dataBase = openHelper.getWritableDatabase();
    }

    public Task select(String name) {
        Cursor cursor = dataBase.query(TABLE_NAME, null, COLUMN_NAME + " = " + name,
                null, null, null, null);
        Task task;
        if (cursor.moveToFirst()) {
            task = new Task();
            task.setTask_name(cursor.getString(NUM_COLUMN_NAME));
            task.setTask_tags(cursor.getString(NUM_COLUMN_TAGS));
            task.setTask_descr(cursor.getString(NUM_COLUMN_DESCR));
            task.setTask_start_dt(cursor.getString(NUM_COLUMN_START_DT));
            task.setTaske_end_dt(cursor.getString(NUM_COLUMN_END_DT));
            task.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
            cursor.close();
            return task;
        }
        cursor.close();
        return null;
    }

    public List<Task> selectAll() {
        Cursor cursor = dataBase.query(TABLE_NAME, null, null,
                null, null, null, null);
        ArrayList<Task> list = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                Task task = new Task();
                task.setTask_name(cursor.getString(NUM_COLUMN_NAME));
                task.setTask_tags(cursor.getString(NUM_COLUMN_TAGS));
                task.setTask_descr(cursor.getString(NUM_COLUMN_DESCR));
                task.setTask_start_dt(cursor.getString(NUM_COLUMN_START_DT));
                task.setTaske_end_dt(cursor.getString(NUM_COLUMN_END_DT));
                task.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
                list.add(task);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insert(List<Task> list) {
        if (list.size() == 0) {
            return 0;
        }
        long count = 0;
        for (Task task: list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_EMAIL, task.getUser_email());
            cv.put(COLUMN_NAME, task.getTask_name());
            cv.put(COLUMN_DESCR, task.getTask_descr());
            cv.put(COLUMN_START_DT, task.getTask_start_dt());
            cv.put(COLUMN_END_DT, task.getTaske_end_dt());
            cv.put(COLUMN_TAGS, task.getTask_tags());
            dataBase.insert(TABLE_NAME, null, cv);
            count++;
        }
        return count;
    }

    public long insert(Task task) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, task.getUser_email());
        cv.put(COLUMN_NAME, task.getTask_name());
        cv.put(COLUMN_DESCR, task.getTask_descr());
        cv.put(COLUMN_START_DT, task.getTask_start_dt());
        cv.put(COLUMN_END_DT, task.getTaske_end_dt());
        cv.put(COLUMN_TAGS, task.getTask_tags());
        dataBase.insert(TABLE_NAME, null, cv);
        return 1;
    }

    public long delete(String name){
        return dataBase.delete(TABLE_NAME,
                COLUMN_NAME + "=?", new String[]{String.valueOf(name)});
    }

    public long update(Task task){
        Log.d("My", task.toString());
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, task.getUser_email());
        cv.put(COLUMN_NAME, task.getTask_name());
        cv.put(COLUMN_DESCR, task.getTask_descr());
        cv.put(COLUMN_START_DT, task.getTask_start_dt());
        cv.put(COLUMN_END_DT, task.getTaske_end_dt());
        cv.put(COLUMN_TAGS, task.getTask_tags());
        return dataBase.update(TABLE_NAME, cv,
                COLUMN_NAME + "=?", new String[]{String.valueOf(task.getTask_name())});
    }

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper( Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_NAME + " TEXT PRIMARY KEY, " +
                    COLUMN_DESCR + " TEXT, " +
                    COLUMN_START_DT + " TEXT, " +
                    COLUMN_END_DT + " TEXT, " +
                    COLUMN_TAGS + " TEXT);";
            Log.d("My", query);
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
