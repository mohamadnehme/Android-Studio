package com.example.preferenced;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText t1,t2;
CheckBox c;
SharedPreferences p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.user);
        t2 = findViewById(R.id.pass);
        c = findViewById(R.id.c);
        p = getSharedPreferences("imad",MODE_PRIVATE);
        String s = p.getString("user","nh");
        String s1 = p.getString("pass","moe");
        if(!(s.equals("nh"))){
            t1.setText(s);
        }
        if(!(s1.equals("moe"))){
            t2.setText(s1);
        }
    }
    public void btn(View v){
        if(c.isChecked()){
            SharedPreferences.Editor pr = p.edit();
            pr.putString("user",t1.getText().toString());
            pr.putString("pass",t2.getText().toString());
            pr.commit();
        }
        if(t1.getText().toString().equals("moe") && t2.getText().toString().equals("nh")){
            Toast.makeText(this,"Succeed",Toast.LENGTH_SHORT).show();
        }
    }
}
