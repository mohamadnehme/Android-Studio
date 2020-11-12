package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void f(View v)
    {
        RadioButton r1 = (RadioButton)findViewById(R.id.r1);
        RadioButton r2 = (RadioButton)findViewById(R.id.r2);
        RadioButton r3 = (RadioButton)findViewById(R.id.r3);
        RadioButton r4 = (RadioButton)findViewById(R.id.r4);
        Button b = (Button)findViewById(R.id.b);
        CheckBox c1 = (CheckBox)findViewById(R.id.c1);
        CheckBox c2 = (CheckBox)findViewById(R.id.c2);
        CheckBox c3 = (CheckBox)findViewById(R.id.c3);
        CheckBox c4 = (CheckBox)findViewById(R.id.c4);
        String s = null;
        if(r1.isChecked()){
            s = r1.getText().toString()+"\n";
        }
        else if(r2.isChecked()){
            s = r2.getText().toString()+"\n";
        }
        else if(r3.isChecked()){
            s = r3.getText().toString()+"\n";
        }
        else if(r4.isChecked()){
            s = r4.getText().toString()+"\n";
        }
        if(c1.isChecked()){
            s = s + "Checkbox choices\n" + c1.getText().toString() + " yes \n";
        }
        else s = s + "Checkbox choices\n" + c1.getText().toString() + " no \n";

        if(c2.isChecked()){
            s = s + c2.getText().toString() + " yes \n";
        }
        else s = s + c2.getText().toString() + " no \n";

        if(c3.isChecked()){
            s = s + c3.getText().toString() + " yes \n";
        }
        else s = s + c3.getText().toString() + " no \n";

        if(c4.isChecked()){
            s = s + c4.getText().toString() + " yes \n";
        }
        else s = s + c4.getText().toString() + " no \n";
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
