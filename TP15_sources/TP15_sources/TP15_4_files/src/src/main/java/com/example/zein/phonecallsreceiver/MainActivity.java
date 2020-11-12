package com.example.zein.phonecallsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private PhoneStateReceiver rec;
    private EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (EditText) findViewById(R.id.phonestxt);
        rec = new PhoneStateReceiver(txt);
        registerReceiver(rec, new IntentFilter("android.intent.action.PHONE_STATE"));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(rec);
    }

    public class PhoneStateReceiver extends BroadcastReceiver {
        private Context c;
        private EditText edt;
        private String savedNumber="";
        private int lastState=0;
        private Date startTime;
        private Date endTime;
        private long duration=-1;

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

                    if(state != lastState) {

                        if (state == telephony.CALL_STATE_OFFHOOK)
                            startTime = new Date();
                        else if(state == telephony.CALL_STATE_IDLE && lastState == telephony.CALL_STATE_OFFHOOK) {
                            endTime = new Date();
                            duration = endTime.getTime() - startTime.getTime();
                            startTime = null;
                            endTime = null;
                            edt.append(incomingNumber+" : duration = "+ (duration/1000) +" seconds\n");
                        }
                        lastState = state;
                       // System.out.println("Phone number: " + incomingNumber);
                        //Toast.makeText(c, "" + incomingNumber, Toast.LENGTH_SHORT).show();
                    }
                }
            }, PhoneStateListener.LISTEN_CALL_STATE);

        }
    }

}
