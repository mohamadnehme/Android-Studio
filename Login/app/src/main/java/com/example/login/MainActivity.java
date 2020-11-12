package com.example.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    List<Users> a;
    EditText temail, tpass;
    String email, pass;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);
        a = new ArrayList<>();
        temail = findViewById(R.id.editText);
        tpass = findViewById(R.id.editText2);
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
        tpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tpass.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
    }

    public void creer(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void login(View v) {
        try {
            a = db.getAllUsers();
            email = temail.getText().toString();
            pass = tpass.getText().toString();
            for (i = 0; i < a.size(); i++) {
                if (email.equals(a.get(i).email) && pass.equals(a.get(i).pass)) {
                    Intent i1 = new Intent(MainActivity.this,Main3Activity.class);
                    i1.putExtra("id",a.get(i).id);
                    startActivity(i1);
                    break;
                }
            }
            if (i == a.size()) {
                Toast.makeText(this, "Email or Password is Wrong", Toast.LENGTH_SHORT).show();
                temail.setTextColor(Color.parseColor("#FF0000"));
                tpass.setTextColor(Color.parseColor("#FF0000"));
            }
        } catch (Exception e) {
        }
    }
}