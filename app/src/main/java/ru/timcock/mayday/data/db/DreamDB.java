package ru.timcock.mayday.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import ru.timcock.mayday.data.Dream;
import ru.timcock.mayday.data.Task;


public class DreamDB {
    private static final String DATABASE_NAME = "dream.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "dream";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TAGS = "tags";
    public static final String COLUMN_DT = "dt";
    public static final String COLUMN_TEXT = "texts";
    public static final Integer NUM_COLUMN_EMAIL = 0;
    public static final Integer NUM_COLUMN_NAME = 1;
    public static final Integer NUM_COLUMN_TAGS = 2;
    public static final Integer NUM_COLUMN_DT = 3;
    public static final Integer NUM_COLUMN_TEXT = 4;
    private SQLiteDatabase dataBase;

    public DreamDB(Context context) {
        DreamDB.OpenHelper openHelper = new DreamDB.OpenHelper(context);
        dataBase = openHelper.getWritableDatabase();
    }

    public Dream select(String name) {
        Cursor cursor = dataBase.query(TABLE_NAME, null, COLUMN_NAME + " = " + name,
                null, null, null, null);
        Dream dream;
        if (cursor.moveToFirst()) {
            dream = new Dream();
            dream.setDream_name(cursor.getString(NUM_COLUMN_NAME));
            dream.setDream_tags(cursor.getString(NUM_COLUMN_TAGS));
            dream.setDream_dt(cursor.getString(NUM_COLUMN_DT));
            dream.setImg_text(cursor.getString(NUM_COLUMN_TEXT));
            dream.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
            cursor.close();
            return dream;
        }
        cursor.close();
        return null;
    }

    public List<Dream> selectAll() {
        Cursor cursor = dataBase.query(TABLE_NAME, null, null,
                null, null, null, null);
        ArrayList<Dream> list = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                Dream dream = new Dream();
                dream.setDream_name(cursor.getString(NUM_COLUMN_NAME));
                dream.setDream_tags(cursor.getString(NUM_COLUMN_TAGS));
                dream.setDream_dt(cursor.getString(NUM_COLUMN_DT));
                dream.setImg_text(cursor.getString(NUM_COLUMN_TEXT));
                dream.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
                list.add(dream);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insert(List<Dream> list) {
        if (list.size() == 0) {
            return 0;
        }
        long count = 0;
        for (Dream dream: list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_EMAIL, dream.getUser_email());
            cv.put(COLUMN_NAME, dream.getDream_name());
            cv.put(COLUMN_DT, dream.getDream_dt());
            cv.put(COLUMN_TEXT, dream.getImg_text());
            cv.put(COLUMN_TAGS, dream.getDream_tags());
            dataBase.insert(TABLE_NAME, null, cv);
            count++;
        }
        return count;
    }

    public long insert(Dream dream) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, dream.getUser_email());
        cv.put(COLUMN_NAME, dream.getDream_name());
        cv.put(COLUMN_DT, dream.getDream_dt());
        cv.put(COLUMN_TEXT, dream.getImg_text());
        cv.put(COLUMN_TAGS, dream.getDream_tags());
        dataBase.insert(TABLE_NAME, null, cv);
        return 1;
    }

    public long delete(String name){
        return dataBase.delete(TABLE_NAME,
                COLUMN_NAME + "=?", new String[]{String.valueOf(name)});
    }

    public long update(Dream dream){
        Log.d("My", dream.toString());
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, dream.getUser_email());
        cv.put(COLUMN_NAME, dream.getDream_name());
        cv.put(COLUMN_DT, dream.getDream_dt());
        cv.put(COLUMN_TEXT, dream.getImg_text());
        cv.put(COLUMN_TAGS, dream.getDream_tags());
        return dataBase.update(TABLE_NAME, cv,
                COLUMN_NAME + "=?", new String[]{String.valueOf(dream.getDream_name())});
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
                    COLUMN_DT + " TEXT, " +
                    COLUMN_TEXT + " TEXT, " +
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
