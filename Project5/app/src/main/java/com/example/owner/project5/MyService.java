package com.example.owner.project5;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

/**
 * Created by Owner on 4/16/2018.
 */

public class MyService extends Service {
    private int eggTotal;
    private final int MY_NOTIF = 3;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        int intValue = intent.getIntExtra("eggValue", 0);
        eggTotal = share.getInt("egg",0);
        
        //breakfast
        if (intValue == -6){

            if (eggTotal + intValue >= 0){
                eggTotal = eggTotal + intValue;

                SharedPreferences.Editor edit = share.edit();

                edit.putInt("egg",eggTotal );

                //commit values
                edit.commit();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification noti = new Notification.Builder(this)
                        .setContentTitle("Egg")
                        .setContentText(" We are having breakfast, you have " + eggTotal + " eggs")
                        .setOngoing(false)
                        .setSmallIcon(R.drawable.egg1)
                        .build();

                notificationManager.notify(MY_NOTIF, noti);


            }else {

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification noti = new Notification.Builder(this)
                        .setContentTitle("Egg")
                        .setContentText(" We are having gruel, you have " + eggTotal + " eggs")
                        .setOngoing(false)
                        .setSmallIcon(R.drawable.egg1)
                        .build();

                notificationManager.notify(MY_NOTIF, noti);
            }
        }
        else {

            if (eggTotal + intValue != -1) {

                eggTotal = eggTotal + intValue;


                SharedPreferences.Editor edit = share.edit();

                edit.putInt("egg", eggTotal);

                //commit values
                edit.commit();

            }
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Notification noti = new Notification.Builder(this)
                    .setContentTitle("Egg")
                    .setContentText(" You have " + eggTotal + " eggs")
                    .setOngoing(false)
                    .setSmallIcon(R.drawable.egg1)
                    .build();

            notificationManager.notify(MY_NOTIF, noti);
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
