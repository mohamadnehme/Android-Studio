package com.example.sum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button b = (Button)findViewById(R.id.b);
        Button b1 = (Button)findViewById(R.id.b1);
        final EditText t1 = (EditText)findViewById(R.id.t1);
        final EditText t2 = (EditText)findViewById(R.id.t2);
        final Intent info = getIntent();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                try {
                    i.putExtra("age", t1.getText().toString());
                    i.putExtra("job", t2.getText().toString());
                    i.putExtra("name", info.getExtras().getString("name"));
                    startActivity(i);
                }catch(Exception e){
                    Toast.makeText(Main2Activity.this,"Enter your age and job",Toast.LENGTH_LONG).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
