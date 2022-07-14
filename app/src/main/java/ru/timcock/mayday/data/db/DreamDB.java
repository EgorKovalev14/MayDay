package ru.timcock.mayday.data.db;

import android.app.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import ru.timcock.mayday.data.Dream;


public class DreamDB {
    private static final String DATABASE_NAME = "dream.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "dreams";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_TEXT = "text";
    public static final String COLUMN_DATE_TIME = "date_time";
    public static final String COLUMN_IMG = "img";
    public static final Integer NUM_COLUMN_ID = 0;
    public static final Integer NUM_COLUMN_EMAIL = 1;
    public static final Integer NUM_COLUMN_TEXT = 2;
    public static final Integer NUM_COLUMN_DATE_TIME = 3;
    public static final Integer NUM_COLUMN_IMG = 4;
    private SQLiteDatabase dataBase;

    public DreamDB(Context context) {
        OpenHelper openHelper = new OpenHelper(context);
        dataBase = openHelper.getWritableDatabase();
    }

    public Dream select(long id) {
        Cursor cursor = dataBase.query(TABLE_NAME, null, COLUMN_ID + " = " + id,
                null, null, null, null);
        Dream person;
        if (cursor.moveToFirst()) {
            person = new Dream();
            person.setId((int) cursor.getLong(NUM_COLUMN_ID));
            person.setEmail(cursor.getString(NUM_COLUMN_EMAIL));
            person.setText(cursor.getString(NUM_COLUMN_TEXT));
            person.setData_time(cursor.getString(NUM_COLUMN_DATE_TIME));
            person.setImg(cursor.getString(NUM_COLUMN_IMG));
            cursor.close();
            return person;
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
                Dream person = new Dream();
                person.setId((int) cursor.getLong(NUM_COLUMN_ID));
                person.setEmail(cursor.getString(NUM_COLUMN_EMAIL));
                person.setText(cursor.getString(NUM_COLUMN_TEXT));
                person.setData_time(cursor.getString(NUM_COLUMN_DATE_TIME));
                person.setImg(cursor.getString(NUM_COLUMN_IMG));
                list.add(person);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public long insert(List<Dream> list) {
        if (list.size() == 0) {
            return 0;
        }
        long count = 0;
        for (Dream person: list) {
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_ID, person.getId());
            cv.put(COLUMN_EMAIL, person.getEmail());
            cv.put(COLUMN_TEXT, person.getText());
            cv.put(COLUMN_DATE_TIME, person.getData_time());
            cv.put(COLUMN_IMG, person.getImg());
            dataBase.insert(TABLE_NAME, null, cv);
            count++;
        }
        return count;
    }

    public long insert(Dream person) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, person.getId());
        cv.put(COLUMN_EMAIL, person.getEmail());
        cv.put(COLUMN_TEXT, person.getText());
        cv.put(COLUMN_DATE_TIME, person.getData_time());
        cv.put(COLUMN_IMG, person.getImg());
        dataBase.insert(TABLE_NAME, null, cv);
        return 1;
    }

    public long delete(long id){
        return dataBase.delete(TABLE_NAME,
                COLUMN_ID + "=?", new String[]{String.valueOf(id)});
    }

    public long update(Dream person){
        Log.d("My", person.toString());
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, person.getId());
        cv.put(COLUMN_EMAIL, person.getEmail());
        cv.put(COLUMN_TEXT, person.getText());
        cv.put(COLUMN_DATE_TIME, person.getData_time());
        cv.put(COLUMN_IMG, person.getImg());
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
                    COLUMN_TEXT + " TEXT, " +
                    COLUMN_DATE_TIME + " TEXT, " +
                    COLUMN_IMG + " TEXT);";
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
