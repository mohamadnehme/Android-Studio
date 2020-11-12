package com.example.guessmax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int x=0,y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button d1 = (Button)findViewById(R.id.b1);
        Button d2 = (Button)findViewById(R.id.b2);
        TextView d = (TextView)findViewById(R.id.t);
        int e = (int) (100*Math.random());
        int f = (int) (100*Math.random());
        d1.setText(Integer.toString(e));
        d2.setText(Integer.toString(f));
        d.setText(x+"/"+y);
    }
    public void tries(View v)
    {
        int a,b,e,f;
        Button d1 = (Button)findViewById(R.id.b1);
        Button d2 = (Button)findViewById(R.id.b2);
        TextView d = (TextView)findViewById(R.id.t);
        a=Integer.parseInt(d1.getText().toString());
        b=Integer.parseInt(d2.getText().toString());
        if(a>=b && v.getId()==R.id.b1)
        {
            x++;
        }

        if(b>=a && v.getId()==R.id.b2)
        {
            x++;
        }
        y++;
        d.setText(x+"/"+y);
        e=(int)(100*Math.random());
        f=(int)(100*Math.random());
        d1.setText(Integer.toString(e));
        d2.setText(Integer.toString(f));
    }








}
