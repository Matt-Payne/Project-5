package com.example.owner.project5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Owner on 4/17/2018.
 */

public class BreakfastService extends Service {
    private final int MY_NOTIF = 3;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        int intValue = intent.getIntExtra("eggBreakfast", 0);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification noti = new Notification.Builder(this)
                .setContentTitle("Egg")
                .setContentText(" We are having breakfast, you have " + intValue + " eggs")
                .setOngoing(false)
                .setSmallIcon(R.drawable.egg1)
                .build();

        notificationManager.notify(MY_NOTIF, noti);

        return super.onStartCommand(intent, flags, startId);
    }
}
