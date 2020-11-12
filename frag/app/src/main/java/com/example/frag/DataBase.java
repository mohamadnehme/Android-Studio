package com.example.frag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.frag.Contacts;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    private static final String dbname = "contact1";
    private static final String dbtable = "client";
    private static final String key_id = "id";
    private static final String key_name = "name";
    private static final String key_ph = "phone";
    private static final int dbvr = 1;
    public DataBase(Context c) {
        super(c,dbname,null,dbvr);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+dbtable+" ( " +key_id+" INTEGER PRIMARY KEY,"+key_name+" TEXT,"+key_ph+" TEXT"+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+dbtable);
        onCreate(db);
    }
    void addContact(Contacts c){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put(key_name,c.getName());
        v.put(key_ph,c.getPh());
        db.insert(dbtable,null,v);
        db.close();
    }
    ArrayList<Contacts> getc(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+dbtable;
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<Contacts> contacts = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Contacts c = new Contacts(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                contacts.add(c);
            }while(cursor.moveToNext());
        }
        db.close();
        return contacts;
    }
    Contacts getone(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM "+dbtable+" WHERE "+key_id +" = "+id;
        Cursor c = db.rawQuery(query,null);
        Contacts contact = null;
        if(c.moveToFirst()){
            contact = new Contacts(Integer.parseInt(c.getString(0)),c.getString(1),c.getString(2));
        }
        return contact;
    }
}
