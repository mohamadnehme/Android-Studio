package com.example.images;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner s = (Spinner)findViewById(R.id.s);
        final ImageView i = (ImageView)findViewById(R.id.i);
        final String str[] = {"a","b","c","d","e","f","g","h"};
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,str);
        s.setAdapter(ad);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(str[0].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.a);
                }
                if(str[1].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.b);
                }
                if(str[2].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.c);
                }
                if(str[3].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.d);
                }
                if(str[4].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.e);
                }
                if(str[5].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.f);
                }
                if(str[6].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.g);
                }
                if(str[7].equals(s.getItemAtPosition(position).toString())){
                    i.setImageResource(R.drawable.h);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
