package com.example.tp9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
TextView t1,t2,t3,t4;
Button b;
Sqlite db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Create Account");
        db= new Sqlite(this);
        Intent i=getIntent();
b=(Button)findViewById(R.id.b);

t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                   String s1=t1.getText().toString();
                  String s2=t2.getText().toString();
                  String s3=t3.getText().toString();
                  String s4=t4.getText().toString();



                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals(""))
                {
                    Toast.makeText(Register.this, "fields can not be empty", Toast.LENGTH_SHORT).show();
                }




                          else {


                    if (s3.equals(s4)) {

                            User user = new User(s2,s1,s3,"0");
                            Toast.makeText(Register.this, user.getEmail(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Register.this, user.getName(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Register.this, user.getPassword(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Register.this, user.getScore(), Toast.LENGTH_SHORT).show();
                        db.add(user);

                        Toast.makeText(Register.this, "Added Completed", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Register.this,Login.class);
                        startActivity(intent);



                    } else {
                        Toast.makeText(Register.this, "Please Check-up your confirmation of your password", Toast.LENGTH_SHORT).show();

                    }
                }






            }
        });
















    }
}
