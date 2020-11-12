package com.example.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button b = (Button)findViewById(R.id.s);
        final EditText t = (EditText)findViewById(R.id.t);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent("abc");
                    i.putExtra("name", t.getText().toString());
                    startActivity(i);

                }catch(Exception e){
                    Toast.makeText(MainActivity.this,"Enter your triple name",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
