package com.example.myapplication;

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
        final ImageView im = (ImageView)findViewById(R.id.im);
        final String str[] = {"a","b","c","d"};
        ArrayAdapter ad = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,str);

        s.setAdapter(ad);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(str[0].equals(s.getItemAtPosition(position).toString())){
                    im.setImageResource(R.drawable.download);
                }
                else
                if(str[1].equals(s.getItemAtPosition(position).toString())){
                    im.setImageResource(R.drawable.downloadd);
                }
                else
                if(str[2].equals(s.getItemAtPosition(position).toString())){
                    im.setImageResource(R.drawable.downloads);
                }
                else
                if(str[3].equals(s.getItemAtPosition(position).toString())){
                    im.setImageResource(R.drawable.downloadr);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
