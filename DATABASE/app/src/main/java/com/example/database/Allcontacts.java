package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Allcontacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcontacts);
        // Get an instance of the Database Handler:
        DatabaseHandler db= new DatabaseHandler(this);
// execute the method getAllContacts to get all of them into the list called

        final List<Contact> contacts = db.getAllContacts();
        ListView l = findViewById(R.id.list);
        ArrayList<String> arrayList = new ArrayList<>();
        for(int i=0;i<contacts.size();i++){
            arrayList.add(contacts.get(i)._id+" "+contacts.get(i)._name+" "+contacts.get(i)._phone_number);
        }
        ArrayAdapter<String> ad = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        l.setAdapter(ad);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i1 = new Intent(Intent.ACTION_DIAL);
                String s = contacts.get(position)._phone_number;
                if(s.charAt(0) == '0'){
                    s = s.substring(1,s.length());
                    i1.setData(Uri.parse("tel:+961"+s));
                }
                i1.setData(Uri.parse("tel:+961"+s));
                startActivity(i1);
            }
        });
    }
}
