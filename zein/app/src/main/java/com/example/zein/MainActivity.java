package com.example.zein;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    ListView v;
    ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v = findViewById(R.id.l);
        arrayList = new ArrayList<>();
        PrintStream output = null;
        try {
            output = new PrintStream(
                    openFileOutput("out.txt", MODE_APPEND));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*output.println("ali 76654321");
        output.println("moe 76343186");
        output.println("bob 81610094");
        output.println("wehbe 71485284");*/
        output.close();
        Scanner scan = null;
        try {
            scan = new Scanner(
                    openFileInput("out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String allText = ""; // read entire file
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            arrayList.add(line);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,arrayList);
        v.setAdapter(adapter);
        scan.close();
        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i1 = new Intent(Intent.ACTION_DIAL);
                i1.setData(Uri.parse("tel:+961"+v.getItemAtPosition(position).toString().split(" ")[1]));
                startActivity(i1);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.add:
// Open Search Activity
                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(i,77);
                return true;
// do something
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode == 77) && (resultCode == RESULT_OK))
        {
            try {
                String name = data.getStringExtra("name");
                String number = data.getStringExtra("number");
                arrayList.add(name+" "+number);
                PrintStream output = null;
                try {
                    output = new PrintStream(openFileOutput("out.txt", MODE_APPEND));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                output.println(name+" "+number);
                output.close();
                ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
                v.setAdapter(adapter);
            }catch(Exception e)
            {
                Toast.makeText(this,"Bad url",Toast.LENGTH_SHORT).show();
            }
        }
    }
}