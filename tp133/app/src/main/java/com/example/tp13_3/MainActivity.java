package com.example.tp13_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    ArrayList<Food> foods;
    ListView listView ;
    String name,categorie,recette;
    ArrayList<String> f;
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        db = new DatabaseHandler (this);
        foods = db.getallfoods();
        f = new ArrayList<>();
        for(int i = 0 ; i < foods.size() ; i++){
            f.add(foods.get(i).getName());
        }
        ArrayAdapter<String> ad = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,f);
        listView.setAdapter(ad);
    }
    public void add(){
        Intent i = new Intent(MainActivity.this,add_food.class);
        startActivityForResult(i,77);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                add();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 77) && (resultCode == RESULT_OK)) {
            String name = data.getStringExtra("name");
            String categorie = data.getStringExtra("categorie");
            String recette = data.getStringExtra("recette");
            if(name.isEmpty() || categorie.isEmpty() || recette.isEmpty()){

            }
            else {
                Food food = new Food(name, categorie, recette);
                db.addfood(food);
                foods = db.getallfoods();
                f = new ArrayList<>();
                for (int i = 0; i < foods.size(); i++) {
                    f.add(foods.get(i).getName());
                }
                ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, f);
                listView.setAdapter(ad);
            }
        }
    }
}
