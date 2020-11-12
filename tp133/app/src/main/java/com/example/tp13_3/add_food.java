package com.example.tp13_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class add_food extends AppCompatActivity {
    EditText t1 , t2 , t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
    }
    public void add(View v){
        Intent i = new Intent();
        i.putExtra("name",t1.getText().toString());
        i.putExtra("categorie",t2.getText().toString());
        i.putExtra("recette",t3.getText().toString());
        setResult(Activity.RESULT_OK,i);
        finish();
    }
}
