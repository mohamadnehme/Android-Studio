package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static class Receivre extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String s = isAirPlaneModeOn(context) == true?"ON":"OFF";
            Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
        }
        private boolean isAirPlaneModeOn(Context c){
            return Settings.System.getInt(c.getContentResolver(),Settings.System.AIRPLANE_MODE_ON,0) != 0;
        }
    }
}
