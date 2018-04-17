package com.example.owner.project5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Owner on 4/16/2018.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int intValue = intent.getIntExtra("eggValue", 0);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification noti = new Notification.Builder(this)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(" You have" + intValue + "eggs")
                .setOngoing(false)
                .build();

        notificationManager.notify(0, noti);

        return super.onStartCommand(intent, flags, startId);
    }
}