package com.example.frag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
    public void open(View view){
        Intent i = new Intent(Main1Activity.this,MainActivity.class);
        i.putExtra("name","mohamad");
        startActivity(i);
    }
}
