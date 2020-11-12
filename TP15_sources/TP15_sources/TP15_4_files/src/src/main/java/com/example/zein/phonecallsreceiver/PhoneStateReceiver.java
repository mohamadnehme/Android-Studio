package com.example.zein.phonecallsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhoneStateReceiver extends BroadcastReceiver {
    private Context c;
    private EditText edt;

    public PhoneStateReceiver(EditText e){
        edt = e;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        c = context;
        final TelephonyManager telephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        telephony.listen(new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                if(! incomingNumber.isEmpty() && state == telephony.CALL_STATE_IDLE) {
                    System.out.println("Phone number: " + incomingNumber);
                    Toast.makeText(c, "" + incomingNumber, Toast.LENGTH_SHORT).show();
                    edt.append(incomingNumber+"\n");
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE);

    }
}
