package com.example.zein.networkchangedreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.TextView;
import android.widget.Toast;

public class NetworkReceiver extends BroadcastReceiver {
    private TextView txt;
    public NetworkReceiver(TextView t){
        super();
        txt=t;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnected();
            if (isConnected) {
                boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
                try {
                    if (isWiFi) {
                        WifiManager mainWifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                        WifiInfo currentWifi = mainWifi.getConnectionInfo();
                        String name = currentWifi.getSSID();
                        String m = currentWifi.getMacAddress();
                        //Toast.makeText(context, "connected to "+name, Toast.LENGTH_LONG).show();
                        txt.setText("connected to " + name +". Mac@ is "+ m);
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        //Toast.makeText(context, "connected to 3G", Toast.LENGTH_LONG).show();
                        txt.setText("Connected to 4G");
                    }

                } catch (Exception e) {
                    //Toast.makeText(context, "Exception:"+e.getMessage(), Toast.LENGTH_LONG).show();
                    //e.printStackTrace();
                    txt.setText("Exception: " + e.getMessage());
                }
            } else {
                //Toast.makeText(context, "Disconnected from network", Toast.LENGTH_LONG).show();
                txt.setText("Disconnected from network");
            }
        }
    }
}
