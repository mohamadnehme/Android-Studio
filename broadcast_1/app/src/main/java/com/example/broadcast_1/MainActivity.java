package com.example.broadcast_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView t;
    private Myreciver mr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.textView);
        mr = new Myreciver();
        registerReceiver(mr,new IntentFilter("com.example.broadcast_1"));
    }
    public void broad(View v){
        Intent i = new Intent("com.example.broadcast_1");
        t.setText("BroadCasting....");
        i.putExtra("message","The Match has started");
        t.setText("Send");
        sendBroadcast(i);
    }
    public class Myreciver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.setText(message);
        }
    }
}
