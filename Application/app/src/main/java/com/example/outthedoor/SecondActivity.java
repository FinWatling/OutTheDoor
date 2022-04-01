package com.example.outthedoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<Date> wakeUpTimesArray = (ArrayList<Date>) bundle.getSerializable("wakeUpTimesArray");


        TextView time = findViewById(R.id.time);

        Date currentTime = new Date();
        String currentDateTimeString = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime); //current time for clock display

        time.setText(currentDateTimeString); //sets current time in app

        System.out.println(wakeUpTimesArray.get(1));

        Button leastSleep = findViewById(R.id.leastSleep);
        leastSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(0)).toString());

        Button bestSleep = findViewById(R.id.bestSleep);
        bestSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(1)).toString());

        Button tooMuchSleep = findViewById(R.id.tooMuchSleep);
        tooMuchSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(2)).toString());



    }
}