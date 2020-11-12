package com.example.frag;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataBase db;
    TextView name,ph;
    LinearLayout l;
    ListView listView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBase(this);
        /*Contacts c = new Contacts("hassan","123");
        db.addContact(c);
        Contacts c1 = new Contacts("mohamad","123");
        db.addContact(c1);
        Contacts c2 = new Contacts("ali","123");
        db.addContact(c2);*/
        name = new EditText(this);
        name.setHint("name");
        name.setWidth(500);
        ph = new EditText(this);
        ph.setWidth(500);
        ph.setHint("phone");
        l=new LinearLayout(this);

        l.addView(name);
        l.addView(ph);
        listView = findViewById(R.id.list);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.add:
                AlertDialog.Builder b = new AlertDialog.Builder(this);
                b.setTitle("Add Contact");
                b.setView(l);
                b.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Contacts c = new Contacts(name.getText().toString(),ph.getText().toString());
                        db.addContact(c);
                        ArrayList<Contacts> a;

                        a = db.getc();

                        ArrayList<String> arrayList = new ArrayList<>();
                        for(int i = 0 ; i < a.size() ; i++){
                            arrayList.add(Integer.toString(a.get(i).id));
                        }
                        ArrayAdapter<String> ad = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
                        listView.setAdapter(ad);
                        dialog.dismiss();
                    }
                });
                b.create().show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onClickB1(View v){

    }
}
