package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME =
            "users4";
    // Contacts table name
    private static final String TABLE_USER  = "user";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FNAME = "fname";
    private static final String KEY_LNAME = "lname";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "pass";
    public DatabaseHandler(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String data = "CREATE TABLE " + TABLE_USER +
                "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_FNAME + " TEXT,"
                + KEY_LNAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_PASS + " TEXT" +
                ")";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        // Create tables again
        onCreate(db);
    }
    void addContact(Users c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, c.getFname());
        values.put(KEY_LNAME, c.getLname());
        values.put(KEY_EMAIL, c.getEmail());
        values.put(KEY_PASS, c.getPass());
// Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection
    }
    // Getting single contact
    Users getUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_USER+" WHERE "+KEY_ID+" = "+id;
        Cursor c = db.rawQuery(query, null);
        c.moveToNext();
        Users u = new Users(Integer.parseInt(c.getString(0)),
                c.getString(1), c.getString(2),c.getString(3),c.getString(4));
        return u;
    }
    List<Users> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_USER;
        Cursor cursor = db.rawQuery(query, null);
        List<Users> user = new ArrayList();
        if(cursor.moveToFirst()){
            do{
                Users c = new Users(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4));
                user.add(c);
            }while(cursor.moveToNext());
        }
        db.close();
// return contact
        return user;
    }
}
