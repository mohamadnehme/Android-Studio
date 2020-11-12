package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView t;
    Users users;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent i = getIntent();
        db = new DatabaseHandler(this);
        t = findViewById(R.id.tid);
        int id = i.getExtras().getInt("id");
        users = db.getUser(id);
        t.setText("Hello "+users.getFname());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.prof:
                Intent i =new Intent(Main3Activity.this,profile.class);
                startActivity(i);
                break;
            case R.id.bac:
                Intent i1 = new Intent(Main3Activity.this, Brief.class);
                startActivity(i1);
                break;
            case R.id.qu:
                Intent i2 = new Intent(Main3Activity.this, Question.class);
                startActivity(i2);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
