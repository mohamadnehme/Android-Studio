package com.example.zein;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText t2,t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
    }
    public void s(View v){
        Intent i = new Intent();
        i.putExtra("name",t1.getText().toString());
        i.putExtra("number",t2.getText().toString());
        setResult(Activity.RESULT_OK,i);
        finish();
    }
}