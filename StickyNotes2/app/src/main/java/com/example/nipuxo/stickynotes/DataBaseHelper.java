package com.example.nipuxo.stickynotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.content.Context;
import android.util.Log;

/**
 * Created by nipuxo on 1/17/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {


    public static  final String TAG = DataBaseHelper.class.getSimpleName();
    public static final String DB_NAME = "noteDatabe.db";
    public static final int DB_VERSION = 1;

    public static final String USER_TABLE = "note";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_NOTES = "notes";

    public static final String CREATE_TABLE_USERS = "CREATE TABLE "+ USER_TABLE+ "(" + COLUMN_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_TITLE + " TEXT," + COLUMN_NOTES + " TEXT);";

    public DataBaseHelper (Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_USERS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+USER_TABLE);
        onCreate(db);
    }

    public boolean getNotes(String title, String notes){

        String selectQuery = "select * from "+USER_TABLE + " where "+ COLUMN_TITLE + " = " + "'" + title +"'" + " and " + COLUMN_NOTES
                + " = " + "'" + notes +"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        cursor.moveToFirst();
        if(cursor.getCount() > 0)
            return true;

        cursor.close();
        db.close();
        return false;
    }

    public void addNote( String title, String notes)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values  = new ContentValues();

        values.put(COLUMN_TITLE,title);
        values.put(COLUMN_NOTES,notes);

        long id = db.insert(USER_TABLE,null,values);
        db.close();

        Log.d(TAG,"user inserted" + id);
    }
}
