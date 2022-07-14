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

public class NoteDB {
    private static final String DATABASE_NAME = "simple.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "dreams";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_TEXT_HEAD = "text_head";
    public static final Integer NUM_COLUMN_ID = 0;
    public static final Integer NUM_COLUMN_EMAIL = 1;
    public static final Integer NUM_COLUMN_TEXT = 2;
    public static final Integer NUM_COLUMN_TEXT_HEAD = 3;
    private SQLiteDatabase dataBase;

    public NoteDB(Context context) {
        OpenHelper openHelper = new OpenHelper(context);
        dataBase = openHelper.getWritableDatabase();
    }

    public Note select(long id) {
        Cursor cursor = dataBase.query(TABLE_NAME, null, COLUMN_ID + " = " + id,
                null, null, null, null);
        Note person;
        if (cursor.moveToFirst()) {
            person = new Note();
            person.setId((int) cursor.getLong(NUM_COLUMN_ID));
            person.setEmail(cursor.getString(NUM_COLUMN_EMAIL));
            person.setText(cursor.getString(NUM_COLUMN_TEXT));
            person.setText_head(cursor.getString(NUM_COLUMN_TEXT_HEAD));
            cursor.close();
            return person;
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
                Note person = new Note();
                person.setId((int) cursor.getLong(NUM_COLUMN_ID));
                person.setEmail(cursor.getString(NUM_COLUMN_EMAIL));
                person.setText(cursor.getString(NUM_COLUMN_TEXT));
                person.setText_head(cursor.getString(NUM_COLUMN_TEXT_HEAD));
                list.add(person);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insert(List<Note> list) {
        if (list.size() == 0) {
            return 0;
        }
        long count = 0;
        for (Note person: list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_ID, person.getId());
            cv.put(COLUMN_EMAIL, person.getEmail());
            cv.put(COLUMN_TEXT, person.getText());
            cv.put(COLUMN_TEXT_HEAD, person.getText_head());
            dataBase.insert(TABLE_NAME, null, cv);
            count++;
        }
        return count;
    }

    public long insert(Note person) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, person.getId());
        cv.put(COLUMN_EMAIL, person.getEmail());
        cv.put(COLUMN_TEXT, person.getText());
        cv.put(COLUMN_TEXT_HEAD, person.getText_head());
        dataBase.insert(TABLE_NAME, null, cv);
        return 1;
    }

    public long delete(long id){
        return dataBase.delete(TABLE_NAME,
                COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    }

    public long update(Note person){
        Log.d("My", person.toString());
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, person.getId());
        cv.put(COLUMN_EMAIL, person.getEmail());
        cv.put(COLUMN_TEXT, person.getText());
        cv.put(COLUMN_TEXT_HEAD, person.getText_head());
        return dataBase.update(TABLE_NAME, cv,
                COLUMN_ID + "=?", new String[]{String.valueOf(person.getId())});
    }

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper( Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_TEXT + " TEXT, " + COLUMN_TEXT_HEAD + " TEXT);";
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
