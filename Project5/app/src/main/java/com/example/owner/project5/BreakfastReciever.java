package com.example.owner.project5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Owner on 4/17/2018.
 */

public class BreakfastReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int intValue = intent.getIntExtra("egg", 0);

        Intent myIntent = new Intent(context,BreakfastService.class);
        myIntent.putExtra("eggBreakfast",intValue);
        context.startService(myIntent);
    }
}
