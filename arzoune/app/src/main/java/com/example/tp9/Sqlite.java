package com.example.tp9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Sqlite extends SQLiteOpenHelper {


    private static final String Database_Name = "database4";
    private static final String Table_Name = "joueur";
    private static final String Email = "email";
    private static final String Name = "nom";
    private static final String Score = "score";
    private static final String Password = "password";
    private static final String KEY_ID = "id";

    public Sqlite(Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ahmad = "CREATE TABLE " + Table_Name + "("+ KEY_ID + " INTEGER PRIMARY KEY," +  Email + " TEXT," + Name + " TEXT," + Password + " TEXT,"+ Score + " TEXT" + ")";
        db.execSQL(ahmad);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(db);
    }

    void add(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Email, user.getEmail());
        values.put(Name, user.getName());
        values.put(Password, user.getPassword());
        values.put(Score,user.getScore());
        db.insert(Table_Name,null, values);
        db.close();
    }

    /*void add1(String s1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Score, s1);
        db.insert(Table_Name2, null, values);
        db.close();

    }*/

    ArrayList GetAllUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query="SELECT * FROM "+Table_Name;
        Cursor cursor = db.rawQuery(query, null);
        ArrayList<User> users = new ArrayList<User>();
        if(cursor.moveToFirst()){
            do{
                User c = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4));
                users.add(c);
        }while(cursor.moveToNext());
        }
        db.close();
        return users;
    }
    User getuser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String q = "SELECT * FROM "+Table_Name+" WHERE "+KEY_ID +" = "+id;
        Cursor c = db.rawQuery(q,null);
        if(c.moveToFirst()){
            User u = new User(Integer.parseInt(c.getString(0)), c.getString(1), c.getString(2),c.getString(3),c.getString(4));
            return u;
        }
        return null;
    }
    void update(String id,String score){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(Score,score);
        db.update(Table_Name,v,KEY_ID +" = ?",new String[] {id});
        db.close();
    }
}