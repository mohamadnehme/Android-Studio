package com.example.calories;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main3Activity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView t = (TextView)findViewById(R.id.t);
        Resources r = getResources();
        Intent i = getIntent();
        double m = i.getExtras().getDouble("m");
        DecimalFormat d = new DecimalFormat("######");
        t.setText("You need to eat \n"+d.format(m)+" calories \n per day");
    }
}
