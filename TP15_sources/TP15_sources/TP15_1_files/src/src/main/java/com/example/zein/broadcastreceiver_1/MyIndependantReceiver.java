package com.example.zein.broadcastreceiver_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MyIndependantReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // assumes WordService is a registered service
            //intent = new Intent(context, WordService.class);
            //context.startService(intent);
            Toast.makeText(context,"The telephone has passed to airplane mode",Toast.LENGTH_LONG).show();

        }
    }