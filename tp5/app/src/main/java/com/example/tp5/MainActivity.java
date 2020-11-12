package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RadioButton r1,r2,r3,r4;
TextView t1,t2,score;
EditText t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int a =(int) (Math.random()*100);
        int b =(int) (Math.random()*100);
        int c =(int) (Math.random()*4);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
        r3 = (RadioButton)findViewById(R.id.r3);
        r4 = (RadioButton)findViewById(R.id.r4);
        if(c == 0) r1.setChecked(true);
        if(c == 1) r2.setChecked(true);
        if(c == 2) r3.setChecked(true);
        if(c == 3) r4.setChecked(true);
        t3 = findViewById(R.id.t3);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        score = findViewById(R.id.score);
        t1.setText(a+"");
        t2.setText(b+"");
        score.setText("0/0");
    }
    ArrayList<String> o = new ArrayList<>();

    public void check(View v){

        String p="";
        double s=0;
        try {
            Double x = Double.parseDouble(t3.getText().toString());
            if (r1.isChecked()) {
                s = Double.parseDouble(t1.getText().toString()) + Double.parseDouble(t2.getText().toString());
                p += "tu fait un operation plus";
            }
            if (r2.isChecked()) {
                s = Double.parseDouble(t1.getText().toString()) - Double.parseDouble(t2.getText().toString());
                p += "tu fait un operation moin";
            }
            if (r3.isChecked()) {
                s = Double.parseDouble(t1.getText().toString()) * Double.parseDouble(t2.getText().toString());
                p += "tu fait un operation fois";
            }
            if (r4.isChecked()) {
                s = Double.parseDouble(t1.getText().toString()) / Double.parseDouble(t2.getText().toString());
                DecimalFormat c = new DecimalFormat(".#");
                String s2 = c.format(s);
                s = Double.parseDouble(s2);
                System.out.println(s);
                p += "tu fait un operation division";
            }
            String str[] = score.getText().toString().split("/");
            if (s == x) {
                int y = Integer.parseInt(str[0]);
                int z = Integer.parseInt(str[1]);
                y++;
                score.setText(y + "/" + z);
                p += " " + "avec score" + y + "/" + z;
            } else {
                int y = Integer.parseInt(str[0]);
                int z = Integer.parseInt(str[1]);
                z--;
                score.setText(y + "/" + z);
                p += " " + "avec score" + y + "/" + z;
            }


            o.add(p);

            int a = (int) (Math.random() * 100);
            int b = (int) (Math.random() * 100);
            int c = (int) (Math.random() * 4);
            if (c == 0) r1.setChecked(true);
            if (c == 1) r2.setChecked(true);
            if (c == 2) r3.setChecked(true);
            if (c == 3) r4.setChecked(true);
            t1.setText(a + "");
            t2.setText(b + "");
        }catch(Exception e){
            Toast.makeText(this,"enter a value",Toast.LENGTH_SHORT).show();
        }
    }
    public void history(View v){
        Intent i = new Intent(MainActivity.this,Main2Activity.class);
        i.putStringArrayListExtra("tab",o);
        startActivity(i);
        }
    }

