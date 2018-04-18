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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private int eggTotal;
    private Button oneEgg;
    private Button twoEggs;
    private Button subEgg;
    private Button makeBreakfast;
    private static final String FILENAME = "data.txt";
    private String dir;
    File text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneEgg = (Button) findViewById(R.id.oneegg);
        twoEggs = (Button) findViewById(R.id.twoeggs);
        subEgg = (Button) findViewById(R.id.subtract1egg);
        makeBreakfast = (Button) findViewById(R.id.breakfast);

        oneEgg.setOnClickListener(this);
        twoEggs.setOnClickListener(this);
        subEgg.setOnClickListener(this);
        makeBreakfast.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        switch (viewId){
            case R.id.oneegg:
                //do stuff

                Intent myIntent = new Intent(this,MyReciever.class);
                myIntent.putExtra("egg",1);
                sendBroadcast(myIntent);
                break;


            case R.id.twoeggs:
                //do stuff

                Intent secIntent = new Intent(this,MyReciever.class);
                secIntent.putExtra("egg",2);
                sendBroadcast(secIntent);
                break;

            case R.id.subtract1egg:
                //do stuff
                //maybe

                    Intent thirdIntent = new Intent(this, MyReciever.class);
                    thirdIntent.putExtra("egg", -1);
                    sendBroadcast(thirdIntent);

                break;

            case R.id.breakfast:
                //do stuff



                    Intent lastIntent = new Intent(this,MyReciever.class);
                    lastIntent.putExtra("egg",-6);
                    sendBroadcast(lastIntent);



                break;
        }

    }
}
