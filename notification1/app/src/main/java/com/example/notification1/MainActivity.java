package com.example.notification1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    private final String CHANNEL_ID = "Personal notification";
    private final int NOTIFICATION_ID = 001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "this is example notification.";
                createNotificationChannel();
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this,CHANNEL_ID
                )
                        .setSmallIcon(R.drawable.ic_message)
                        .setContentTitle("new notification")
                        .setContentText(message)
                        .setAutoCancel(true);
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.addFlags(i.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("message", message);
                PendingIntent p = PendingIntent.getActivity(MainActivity.this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(p);
                //NotificationManager m = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                //m.notify(0, builder.build());
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
                notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
            }
        });
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Personal notification";
            String description = "Include all the personal notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}