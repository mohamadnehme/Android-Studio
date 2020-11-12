package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Main2Activity extends AppCompatActivity {
    DatabaseHandler db;
    EditText tname,tname1,temail,tpass,tconf;
    String fname,lname,email,pass,conf;
    List<Users> a;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        db = new DatabaseHandler (this);
        tname = findViewById(R.id.fname);
        tname1 = findViewById(R.id.lname);
        temail = findViewById(R.id.temail);
        tpass = findViewById(R.id.pass);
        tconf = findViewById(R.id.conf);
        a = db.getAllUsers();
        tconf.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tconf.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
        temail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                temail.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });

    }
    public void back(View view){
        finish();
    }
    public void reg(View view) {
        fname = tname.getText().toString();
        lname = tname1.getText().toString();
        email = temail.getText().toString();
        pass = tpass.getText().toString();
        conf = tconf.getText().toString();
        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || pass.isEmpty() || conf.isEmpty()) {
            Toast.makeText(this, "Please enter the data", Toast.LENGTH_SHORT).show();
        } else {
            if (conf.equals(pass)) {
                for (i = 0; i < a.size(); i++) {
                    if (email.equals(a.get(i).email)) {
                        Toast.makeText(this, "Email exist", Toast.LENGTH_SHORT).show();
                        temail.setTextColor(Color.parseColor("#FF0000"));
                        break;
                    }
                }
                if (i == a.size()) {
                    Users u = new Users(fname,lname, email, pass);
                    db.addContact(u);
                    a = db.getAllUsers();
                    Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show();

                }
            } else {
                tconf.setTextColor(Color.parseColor("#FF0000"));
                Toast.makeText(this, "Confirmation Wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
}