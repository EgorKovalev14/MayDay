package ru.timcock.mayday.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import ru.timcock.mayday.data.Goal;

public class GoalDB {
    private static final String DATABASE_NAME = "goal.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "goal";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_TAGS = "tags";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_END_DT = "end_dt";
    public static final String COLUMN_START_DT = "start_dt";
    public static final String COLUMN_SUCCESS = "succes";
    public static final String COLUMN_DESCR = "descr";
    public static final String COLUMN_NAME = "name";
    public static final Integer NUM_COLUMN_EMAIL = 0;
    public static final Integer NUM_COLUMN_TAGS = 1;
    public static final Integer NUM_COLUMN_TIME = 2;
    public static final Integer NUM_COLUMN_END_DT = 3;
    public static final Integer NUM_COLUMN_START_DT = 4;
    public static final Integer NUM_COLUMN_SUCCESS = 5;
    public static final Integer NUM_COLUMN_DESCR = 6;
    public static final Integer NUM_COLUMN_NAME = 7;
    private SQLiteDatabase dataBase;

    public GoalDB(Context context) {
        GoalDB.OpenHelper openHelper = new GoalDB.OpenHelper(context);
        dataBase = openHelper.getWritableDatabase();
    }

    public Goal select(String name) {
        Cursor cursor = dataBase.query(TABLE_NAME, null, COLUMN_NAME + " = " + name,
                null, null, null, null);
        Goal goal;
        if (cursor.moveToFirst()) {
            goal = new Goal();
            goal.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
            goal.setGoal_tags(cursor.getString(NUM_COLUMN_TAGS));
            goal.setData_time(cursor.getString(NUM_COLUMN_TIME));
            goal.setGoal_end_dt(cursor.getString(NUM_COLUMN_END_DT));
            goal.setGoal_start_dt(cursor.getString(NUM_COLUMN_START_DT));
            goal.setGoal_success(cursor.getString(NUM_COLUMN_SUCCESS));
            goal.setGoal_descr(cursor.getString(NUM_COLUMN_DESCR));
            goal.setGoal_name(cursor.getString(NUM_COLUMN_NAME));
            cursor.close();
            return goal;
        }
        cursor.close();
        return null;
    }

    public List<Goal> selectAll() {
        Cursor cursor = dataBase.query(TABLE_NAME, null, null,
                null, null, null, null);
        ArrayList<Goal> list = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                Goal goal = new Goal();
                goal.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
                goal.setGoal_tags(cursor.getString(NUM_COLUMN_TAGS));
                goal.setData_time(cursor.getString(NUM_COLUMN_TIME));
                goal.setGoal_end_dt(cursor.getString(NUM_COLUMN_END_DT));
                goal.setGoal_start_dt(cursor.getString(NUM_COLUMN_START_DT));
                goal.setGoal_success(cursor.getString(NUM_COLUMN_SUCCESS));
                goal.setGoal_descr(cursor.getString(NUM_COLUMN_DESCR));
                goal.setGoal_name(cursor.getString(NUM_COLUMN_NAME));
                list.add(goal);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insert(List<Goal> list) {
        if (list.size() == 0) {
            return 0;
        }
        long count = 0;
        for (Goal goal: list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_EMAIL, goal.getUser_email());
            cv.put(COLUMN_TAGS, goal.getGoal_tags());
            cv.put(COLUMN_TIME, goal.getData_time());
            cv.put(COLUMN_END_DT, goal.getGoal_end_dt());
            cv.put(COLUMN_START_DT, goal.getGoal_start_dt());
            cv.put(COLUMN_SUCCESS, goal.getGoal_success());
            cv.put(COLUMN_DESCR, goal.getGoal_descr());
            cv.put(COLUMN_NAME, goal.getGoal_name());
            dataBase.insert(TABLE_NAME, null, cv);
            count++;
        }
        return count;
    }

    public long insert(Goal goal) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, goal.getUser_email());
        cv.put(COLUMN_TAGS, goal.getGoal_tags());
        cv.put(COLUMN_TIME, goal.getData_time());
        cv.put(COLUMN_END_DT, goal.getGoal_end_dt());
        cv.put(COLUMN_START_DT, goal.getGoal_start_dt());
        cv.put(COLUMN_SUCCESS, goal.getGoal_success());
        cv.put(COLUMN_DESCR, goal.getGoal_descr());
        cv.put(COLUMN_NAME, goal.getGoal_name());
        dataBase.insert(TABLE_NAME, null, cv);
        return 1;
    }

    public long delete(String name){
        return dataBase.delete(TABLE_NAME,
                COLUMN_NAME + "=?", new String[]{String.valueOf(name)});
    }

    public long update(Goal goal){
        Log.d("My", goal.toString());
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, goal.getUser_email());
        cv.put(COLUMN_TAGS, goal.getGoal_tags());
        cv.put(COLUMN_TIME, goal.getData_time());
        cv.put(COLUMN_END_DT, goal.getGoal_end_dt());
        cv.put(COLUMN_START_DT, goal.getGoal_start_dt());
        cv.put(COLUMN_SUCCESS, goal.getGoal_success());
        cv.put(COLUMN_DESCR, goal.getGoal_descr());
        cv.put(COLUMN_NAME, goal.getGoal_name());
        return dataBase.update(TABLE_NAME, cv,
                COLUMN_NAME + "=?", new String[]{String.valueOf(goal.getGoal_name())});
    }

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper( Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_TAGS + " TEXT, " +
                    COLUMN_TIME + " TEXT, " +
                    COLUMN_END_DT + " TEXT, " +
                    COLUMN_START_DT + " TEXT, " +
                    COLUMN_SUCCESS + " TEXT, " +
                    COLUMN_DESCR + " TEXT, " +
                    COLUMN_NAME + " TEXT PRIMARY KEY);";
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
