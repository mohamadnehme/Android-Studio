package com.example.tp8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        int s = i.getExtras().getInt("s");
        ArrayList<String> a = i.getStringArrayListExtra("list");
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,a);
        ListView l = findViewById(R.id.l);
        l.setAdapter(ad);
        TextView t = findViewById(R.id.t);
        t.setText(s*10+"% Correct");
    }
    public void new1 ( View v){
        finish();
    }
}
