package ru.timcock.mayday.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import ru.timcock.mayday.data.Note;
import ru.timcock.mayday.data.Task;

public class NoteDB {
    private static final String DATABASE_NAME = "note.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "note";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCR = "descr";
    public static final String COLUMN_IMG = "img";
    public static final String COLUMN_DT = "end_dt";
    public static final String COLUMN_TAGS = "tags";
    public static final Integer NUM_COLUMN_EMAIL = 0;
    public static final Integer NUM_COLUMN_NAME = 1;
    public static final Integer NUM_COLUMN_DESCR = 2;
    public static final Integer NUM_COLUMN_IMG = 3;
    public static final Integer NUM_COLUMN_DT = 4;
    public static final Integer NUM_COLUMN_TAGS = 5;
    private SQLiteDatabase dataBase;

    public NoteDB(Context context) {
        NoteDB.OpenHelper openHelper = new NoteDB.OpenHelper(context);
        dataBase = openHelper.getWritableDatabase();
    }

    public Note select(String name) {
        Cursor cursor = dataBase.query(TABLE_NAME, null, COLUMN_NAME + " = " + name,
                null, null, null, null);
        Note note;
        if (cursor.moveToFirst()) {
            note = new Note();
            note.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
            note.setNote_name(cursor.getString(NUM_COLUMN_NAME));
            note.setNote_descr(cursor.getString(NUM_COLUMN_DESCR));
            note.setNote_img(cursor.getString(NUM_COLUMN_IMG));
            note.setNote_dt(cursor.getString(NUM_COLUMN_DT));
            note.setNote_tags(cursor.getString(NUM_COLUMN_TAGS));
            cursor.close();
            return note;
        }
        cursor.close();
        return null;
    }

    public List<Note> selectAll() {
        Cursor cursor = dataBase.query(TABLE_NAME, null, null,
                null, null, null, null);
        ArrayList<Note> list = new ArrayList<>();
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            do {
                Note note = new Note();
                note.setUser_email(cursor.getString(NUM_COLUMN_EMAIL));
                note.setNote_name(cursor.getString(NUM_COLUMN_NAME));
                note.setNote_descr(cursor.getString(NUM_COLUMN_DESCR));
                note.setNote_img(cursor.getString(NUM_COLUMN_IMG));
                note.setNote_dt(cursor.getString(NUM_COLUMN_DT));
                note.setNote_tags(cursor.getString(NUM_COLUMN_TAGS));
                list.add(note);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insert(List<Note> list) {
        if (list.size() == 0) {
            return 0;
        }
        long count = 0;
        for (Note note: list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_EMAIL, note.getUser_email());
            cv.put(COLUMN_NAME, note.getNote_name());
            cv.put(COLUMN_DESCR, note.getNote_descr());
            cv.put(COLUMN_IMG, note.getNote_img());
            cv.put(COLUMN_DT, note.getNote_dt());
            cv.put(COLUMN_TAGS, note.getNote_tags());
            dataBase.insert(TABLE_NAME, null, cv);
            count++;
        }
        return count;
    }

    public long insert(Note note) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, note.getUser_email());
        cv.put(COLUMN_NAME, note.getNote_name());
        cv.put(COLUMN_DESCR, note.getNote_descr());
        cv.put(COLUMN_IMG, note.getNote_img());
        cv.put(COLUMN_DT, note.getNote_dt());
        cv.put(COLUMN_TAGS, note.getNote_tags());
        dataBase.insert(TABLE_NAME, null, cv);
        return 1;
    }

    public long delete(String name){
        return dataBase.delete(TABLE_NAME,
                COLUMN_NAME + "=?", new String[]{String.valueOf(name)});
    }

    public long update(Note note){
        Log.d("My", note.toString());
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, note.getUser_email());
        cv.put(COLUMN_NAME, note.getNote_name());
        cv.put(COLUMN_DESCR, note.getNote_descr());
        cv.put(COLUMN_IMG, note.getNote_img());
        cv.put(COLUMN_DT, note.getNote_dt());
        cv.put(COLUMN_TAGS, note.getNote_tags());
        return dataBase.update(TABLE_NAME, cv,
                COLUMN_NAME + "=?", new String[]{String.valueOf(note.getNote_name())});
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
                    COLUMN_IMG + " TEXT, " +
                    COLUMN_DT + " TEXT, " +
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
