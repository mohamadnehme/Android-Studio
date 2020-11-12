package com.example.zein.broadcastreceiver_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static TextView txtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MyReceiver mr = new MyReceiver();
        txtv = (TextView) findViewById(R.id.txtview);
       //registerReceiver(mr, new IntentFilter("android.intent.action.AIRPLANE_MODE"));

    }
    public static class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // assumes WordService is a registered service
            //intent = new Intent(context, WordService.class);
            //context.startService(intent);
            //Toast.makeText(context,"The telephone has passed to airplane mode",Toast.LENGTH_LONG).show();
            String s = isAirplaneModeOn(context)==true?"ON":"OFF";
            txtv.setText("The aeroplane mode is passed to "+ s);
        }
        private boolean isAirplaneModeOn(Context context) {

            return Settings.System.getInt(context.getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0) != 0;

        }
    }
}
