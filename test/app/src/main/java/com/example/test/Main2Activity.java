package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent data = this.getIntent();
        String s = data.getExtras().getString("a");
        int a = data.getExtras().getInt("b");
        //Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        //Toast.makeText(this,a+"",Toast.LENGTH_SHORT).show();

    }
}
