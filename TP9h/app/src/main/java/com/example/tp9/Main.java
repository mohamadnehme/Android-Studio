package com.example.tp9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void cours(View v){
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }
    public void quiz(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
