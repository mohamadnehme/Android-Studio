package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyAsyncTask myAsyncTask;
    String id;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);

        id = textView.getText().toString();
        myAsyncTask = new MyAsyncTask(textView);
        myAsyncTask.execute(id);

    }
    public void start(View v){
        if(myAsyncTask.isCancelled()){
            myAsyncTask = new MyAsyncTask(textView);
            id = textView.getText().toString();
            myAsyncTask.execute(id);
        }
    }
    public void reset(View v){
        myAsyncTask.cancel(true);
        myAsyncTask = new MyAsyncTask(textView);
        id = textView.getText().toString();
        myAsyncTask.execute("1");
    }
    public void stop(View v){
        myAsyncTask.cancel(true);
    }
}
