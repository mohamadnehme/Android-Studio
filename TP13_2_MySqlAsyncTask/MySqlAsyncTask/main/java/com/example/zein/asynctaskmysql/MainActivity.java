package com.example.zein.asynctaskmysql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void search(View view)
    {
        EditText editText = (EditText)findViewById(R.id.editID);
        String id = editText.getText().toString();

        //MyThread myThread = new MyThread(id);
        //myThread.start();

        TextView textView = (TextView)findViewById(R.id.textView);
        MyAsyncTask myAsyncTask = new MyAsyncTask(textView);
        myAsyncTask.execute(id);

    }
}
