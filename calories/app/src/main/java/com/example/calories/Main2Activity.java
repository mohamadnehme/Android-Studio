package com.example.calories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {
    EditText t1,t2;
    Spinner s;
    RadioButton r1,r2;
    double m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1 = (EditText)findViewById(R.id.t1);
        t2 = (EditText)findViewById(R.id.t2);
        s = (Spinner)findViewById(R.id.spinner);
        r1 = (RadioButton)findViewById(R.id.r1);
        r2 = (RadioButton)findViewById(R.id.r2);
    }
    public double topound(int kg){
        return kg*2.2;
    }
    public double toinch(int cm){
        return cm/2.54;
    }
    public void bmi(View v){
        try {
            Double c;
            c = Double.parseDouble(t1.getText().toString()) / ((Double.parseDouble(t2.getText().toString()) / 100) * (Double.parseDouble(t2.getText().toString()) / 100));
            DecimalFormat d = new DecimalFormat("###.##");
            Toast.makeText(this, d.format(c), Toast.LENGTH_SHORT).show();
        }catch(Exception e){

        }
    }
    public void cal(View v){
        int position = s.getSelectedItemPosition();
        if(r1.isChecked()){
           m = 665+(6.3*topound(Integer.parseInt(t1.getText().toString())))+(12.9*toinch(Integer.parseInt(t2.getText().toString())))-(6.8*24);
        }else
        if(r2.isChecked() && s.getItemAtPosition(position).equals("Below 24")){
            m = 655+(4.3*topound(Integer.parseInt(t1.getText().toString())))+(4.7*toinch(Integer.parseInt(t2.getText().toString())))-(4.7*24);
        }
        else if(r2.isChecked() && s.getItemAtPosition(position).equals("Above 24")){
            m = 455+(4.3*topound(Integer.parseInt(t1.getText().toString())))+(4.7*toinch(Integer.parseInt(t2.getText().toString())))-(4.7*24);
        }
        else {Toast.makeText(this,"Enter your Gender",Toast.LENGTH_SHORT).show(); return;}
        Intent i = new Intent(Main2Activity.this,Main3Activity.class);
        i.putExtra("m",m);
        startActivity(i);
    }
}
