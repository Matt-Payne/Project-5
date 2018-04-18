package com.example.owner.project5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Owner on 4/16/2018.
 */

public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int intValue = intent.getIntExtra("egg", 0);

        Intent myIntent = new Intent(context,MyService.class);
        myIntent.putExtra("eggValue",intValue);
        context.startService(myIntent);
        context.stopService(myIntent);
    }
}
