package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler (this);
    }
    public void displayAll(View v){
        Intent i = new Intent(this, Allcontacts.class);
        startActivity(i); }
    public void saveContact(View v){
        EditText e1 = (EditText) findViewById(R.id.namefield);
        EditText e2 = (EditText) findViewById(R.id.phonefield);
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();
        Contact newContact = new Contact(s1,s2);
        db.addContact(newContact);
    }
}
