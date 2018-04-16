package com.example.owner.project5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int eggTotal;
    private Button oneEgg;
    private Button twoEggs;
    private Button subEgg;
    private Button makeBreakfast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneEgg = (Button)findViewById(R.id.oneegg);
        twoEggs = (Button)findViewById(R.id.twoeggs);
        subEgg = (Button)findViewById(R.id.subtract1egg);
        makeBreakfast = (Button)findViewById(R.id.breakfast);




    }
    @Override
    protected void onResume(){

        super.onResume();

    }
    @Override
    protected void onPause(){
        super.onPause();

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId){
            case R.id.oneegg:
                //do stuff
                eggTotal = eggTotal + 1;
                Intent myIntent = new Intent();
                break;


            case R.id.twoeggs:
                //do stuff
                eggTotal = eggTotal + 2;
                break;

            case R.id.subtract1egg:
                //do stuff
                eggTotal = eggTotal - 1;
                break;

            case R.id.breakfast:
                //do stuff
                if (eggTotal < 6 ){

                    eggTotal = eggTotal - 6;
                    //run intent
                }
                else{

                    //gruel thing

                }
                break;
        }

    }
}
