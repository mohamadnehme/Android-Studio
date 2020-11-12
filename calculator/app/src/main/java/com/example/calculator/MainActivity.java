package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void c(View v)
    {
        double b=0;
        Button e = (Button)findViewById(R.id.e);
        EditText t1 = (EditText)findViewById(R.id.t1);
        EditText t2 = (EditText)findViewById(R.id.t2);
        TextView t3 = (TextView)findViewById(R.id.t3);
        RadioButton r1 = (RadioButton)findViewById(R.id.r1);
        RadioButton r2 = (RadioButton)findViewById(R.id.r2);
        RadioButton r3 = (RadioButton)findViewById(R.id.r3);
        RadioButton r4 = (RadioButton)findViewById(R.id.r4);
        try {
            if (r1.isChecked()) {
                b = Double.parseDouble(t1.getText().toString()) + Double.parseDouble(t2.getText().toString());
            }
            if (r2.isChecked()) {
                b = Double.parseDouble(t1.getText().toString()) - Double.parseDouble(t2.getText().toString());
            }
            if (r3.isChecked()) {
                b = Double.parseDouble(t1.getText().toString()) * Double.parseDouble(t2.getText().toString());
            }
            if (r4.isChecked()) {
                b = Double.parseDouble(t1.getText().toString()) / Double.parseDouble(t2.getText().toString());
            }
            t3.setText(Double.toString(b));
        }catch (Exception e1)
        {
            Toast.makeText(this, "erreur", Toast.LENGTH_LONG).show();
        }
    }
}
