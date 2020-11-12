package com.example.tp13_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Version
     private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "contactsManager";
    // Contacts table name
     private static final String TABLE_FOODS = "food";
// Contacts Table Columns names
 private static final String KEY_ID = "id";
 private static final String KEY_NAME = "name";
 private static final String KEY_CAT = "categorie";
 private static final String KEY_REC = "recette";

    public DatabaseHandler(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FOODS_TABLE = "CREATE TABLE " + TABLE_FOODS + "("+ KEY_ID + " INTEGER PRIMARY KEY," +  KEY_NAME + " TEXT," + KEY_CAT + " TEXT," + KEY_REC + " TEXT"+")";
        db.execSQL(CREATE_FOODS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOODS);
        // Create tables again
        onCreate(db);
    }

    void addfood(Food c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, c.getName());
        values.put(KEY_CAT, c.get_categorie());
        values.put(KEY_REC, c.get_recette());
// Inserting Row
        db.insert(TABLE_FOODS, null, values);
        db.close(); // Closing database connection
    }

    ArrayList<Food> getallfoods() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query="SELECT * FROM "+TABLE_FOODS;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<Food> foods = new ArrayList<Food>();
        if(cursor.moveToFirst()){
            do{
                Food f = new Food(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),cursor.getString(3));
                foods.add(f);
        }while(cursor.moveToNext());
        } db.close(); // return contact
         return foods;
    }
}
