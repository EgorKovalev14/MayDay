package ru.timcock.mayday.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import ru.timcock.mayday.data.Dream;
import ru.timcock.mayday.data.Goal;

public class GoalDB {
    private static final String DATABASE_NAME = "goal.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "goals";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_TAG = "tag";
    public static final String COLUMN_DATE_TIME = "date_time";
    public static final String COLUMN_END_DATE = "end_date";
    public static final Integer NUM_COLUMN_ID = 0;
    public static final Integer NUM_COLUMN_EMAIL = 1;
    public static final Integer NUM_COLUMN_TAG = 2;
    public static final Integer NUM_COLUMN_DATE_TIME = 3;
    public static final Integer NUM_COLUMN_END_DATE = 4;
    private SQLiteDatabase dataBase;

    public GoalDB(Context context) {
        GoalDB.OpenHelper openHelper = new GoalDB.OpenHelper(context);
        dataBase = openHelper.getWritableDatabase();
    }

    public Goal select(long id) {
        Cursor cursor = dataBase.query(TABLE_NAME, null, COLUMN_ID + " = " + id,
                null, null, null, null);
        Goal person;
        if (cursor.moveToFirst()) {
            person = new Goal();
            person.setId((int) cursor.getLong(NUM_COLUMN_ID));
            person.setEmail(cursor.getString(NUM_COLUMN_EMAIL));
            person.setTag(cursor.getString(NUM_COLUMN_TAG));
            person.setData_time(cursor.getString(NUM_COLUMN_DATE_TIME));
            person.setEnd_date(cursor.getString(NUM_COLUMN_END_DATE));
            cursor.close();
            return person;
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
                Goal person = new Goal();
                person.setId((int) cursor.getLong(NUM_COLUMN_ID));
                person.setEmail(cursor.getString(NUM_COLUMN_EMAIL));
                person.setTag(cursor.getString(NUM_COLUMN_TAG));
                person.setData_time(cursor.getString(NUM_COLUMN_DATE_TIME));
                person.setEnd_date(cursor.getString(NUM_COLUMN_END_DATE));
                list.add(person);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insert(List<Goal> list) {
        if (list.size() == 0) {
            return 0;
        }
        long count = 0;
        for (Goal person: list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_ID, person.getId());
            cv.put(COLUMN_EMAIL, person.getEmail());
            cv.put(COLUMN_TAG, person.getTag());
            cv.put(COLUMN_DATE_TIME, person.getData_time());
            cv.put(COLUMN_END_DATE, person.getEnd_date());
            dataBase.insert(TABLE_NAME, null, cv);
            count++;
        }
        return count;
    }

    public long insert(Goal person) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, person.getId());
        cv.put(COLUMN_EMAIL, person.getEmail());
        cv.put(COLUMN_TAG, person.getTag());
        cv.put(COLUMN_DATE_TIME, person.getData_time());
        cv.put(COLUMN_END_DATE, person.getEnd_date());
        dataBase.insert(TABLE_NAME, null, cv);
        return 1;
    }

    public long delete(long id){
        return dataBase.delete(TABLE_NAME,
                COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    }

    public long update(Goal person){
        Log.d("My", person.toString());
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, person.getId());
        cv.put(COLUMN_EMAIL, person.getEmail());
        cv.put(COLUMN_TAG, person.getTag());
        cv.put(COLUMN_DATE_TIME, person.getData_time());
        cv.put(COLUMN_END_DATE, person.getEnd_date());
        return dataBase.update(TABLE_NAME, cv,
                COLUMN_ID + "=?", new String[]{String.valueOf(person.getId())});
    }

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_EMAIL + " TEXT, " + COLUMN_TAG + " TEXT, " +
                    COLUMN_DATE_TIME + " TEXT, " + COLUMN_END_DATE + " TEXT);";
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
