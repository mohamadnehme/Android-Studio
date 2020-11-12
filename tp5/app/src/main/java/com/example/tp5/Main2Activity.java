package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView l = findViewById(R.id.l);
        Intent i = getIntent();
        ArrayList<String> a ;
        a = i.getStringArrayListExtra("tab");
        ArrayAdapter <String> ad = new ArrayAdapter(Main2Activity.this, android.R.layout.simple_list_item_1, a);
        l.setAdapter(ad);
    }
}
