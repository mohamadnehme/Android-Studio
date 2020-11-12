package com.example.tp9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.list_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.show:
                Intent i = new Intent(Main.this,list.class);
                startActivity(i);
                return true;

                default:return false;
        }
    }

    public void cours(View v){
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }
    public void quiz(View v){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }
    public void close(View v){
        // moveTaskToBack(true);
        // android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(1);
        finish();
        System.exit(0);
    }
}
