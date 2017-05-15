package com.example.rahul.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button okay;
    private static final int NOTIFICATION_SIMPLE = 1234;
    private static final int REQ_NOTIFICATION = 4569;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showNotification();
                
            }
        });

    }

    private void showNotification() {

        Intent intent = new Intent(this,NotificationActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(this,REQ_NOTIFICATION,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Action action = new NotificationCompat
                .Action.Builder(R.mipmap.ic_launcher,"Action",pendingIntent).build();


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Title");
        builder.setContentInfo("Information Notification")
        .setContentText("jdbvbdfv   nfdnsf dfsdfidfdfbs  buufbudsbsad  ifiijsdb  ")
        .setDefaults(Notification.DEFAULT_ALL)
        .setOngoing(true)
        .setContentIntent(pendingIntent)
        .addAction(action)
        .setAutoCancel(true);


        Notification notification = builder.build();
        NotificationManager notifictionManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notifictionManager.notify(NOTIFICATION_SIMPLE,notification);

    }
}
