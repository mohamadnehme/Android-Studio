package com.example.tp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        ArrayList<String> a = i.getStringArrayListExtra("a");
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,a);
        ListView l = findViewById(R.id.l);
        l.setAdapter(ad);
        TextView t1 = findViewById(R.id.t1);
        t1.setText("Total Price = "+i.getExtras().getInt("t")+" LBP");
    }
}
