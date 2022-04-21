package com.example.outthedoor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Date;

public class SleepingSoonActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleeping_soon);

        TimePicker tp = findViewById(R.id.timePicker);
        tp.setIs24HourView(true);

        Button submitButton = findViewById(R.id.submitSleepTime);

        submitButton.setOnClickListener(view -> {

            int hour = tp.getHour();
            int min = tp.getMinute();

            Date date = new Date(); //date/time selected by user
            date.setHours(hour);
            date.setMinutes(min);

            Intent intent = new Intent(SleepingSoonActivity.this, SecondActivity.class);
            Bundle bundle = new Bundle();
            ArrayList<Date> wakeUpTimesArray = calculateWakeTime(date);
            bundle.putSerializable("wakeUpTimesArrayFromSleepingSoonActivity", wakeUpTimesArray);
            intent.putExtras(bundle);
            intent.putExtra("TimeOfSleep", date);
            intent.putExtra("fromID", "SleepingSoonActivity");
            startActivity(intent);


        });



    }
}