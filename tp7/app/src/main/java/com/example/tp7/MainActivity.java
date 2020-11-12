package com.example.tp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RadioButton r1,r2,r3;
CheckBox c1,c2,c3,c4;
TextView t1;
int s,total;
String p;
    ArrayList<String> a = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        s = 0;
        total = 0;
        t1.setText("Price Item = 0 LBP");
    }
    public void compte(View v){
        p= "";
        s=0;
        if(r1.isChecked()){
            s += 8000;
            p += "Small-";
        }
        if(r2.isChecked()){
            s += 10000;
            p += "Medium-";
        }
        if(r3.isChecked()){
            s += 12000;
            p += "Large-";
        }
        if(c1.isChecked()){
            s += 2000;
            p += "Sausage-";
        }
        if(c2.isChecked()){
            s += 2000;
            p += "Pepperoni-";
        }
        if(c3.isChecked()){
            s += 2000;
            p += "Olives-";
        }
        if(c4.isChecked()){
            s += 2000;
            p += "Mushrooms";
        }
        p += "Price = "+s+" LBP";
        t1.setText(s+"");
    }
    public void add(View v){
        p= "";
        s=0;
        if(r1.isChecked()){
            s += 8000;
            p += "Small-";
        }
        if(r2.isChecked()){
            s += 10000;
            p += "Medium-";
        }
        if(r3.isChecked()){
            s += 12000;
            p += "Large-";
        }
        if(c1.isChecked()){
            s += 2000;
            p += "Sausage-";
        }
        if(c2.isChecked()){
            s += 2000;
            p += "Pepperoni-";
        }
        if(c3.isChecked()){
            s += 2000;
            p += "Olives-";
        }
        if(c4.isChecked()){
            s += 2000;
            p += "Mushrooms";
        }
        p += "Price = "+s+" LBP";
        a.add(p);
        total += s;

    }
    public void h(View v){
        Intent i = new Intent(MainActivity.this,Main2Activity.class);
        i.putStringArrayListExtra("a",a);
        i.putExtra("t",total);
        startActivity(i);
    }
}
