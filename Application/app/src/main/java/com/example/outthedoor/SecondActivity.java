package com.example.outthedoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
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

        leastSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hours = wakeUpTimesArray.get(0).getHours();
                int minutes = wakeUpTimesArray.get(0).getMinutes();

                Intent setAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
               setAlarm.putExtra(AlarmClock.EXTRA_HOUR, hours);
               setAlarm.putExtra(AlarmClock.EXTRA_MINUTES,  minutes);
               startActivity(setAlarm);


            }
        });

        Button bestSleep = findViewById(R.id.bestSleep);
        bestSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(1)).toString());

        bestSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hours = wakeUpTimesArray.get(1).getHours();
                int minutes = wakeUpTimesArray.get(1).getMinutes();

                Intent setAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
                setAlarm.putExtra(AlarmClock.EXTRA_HOUR, hours);
                setAlarm.putExtra(AlarmClock.EXTRA_MINUTES,  minutes);
                startActivity(setAlarm);


            }
        });

        Button tooMuchSleep = findViewById(R.id.tooMuchSleep);
        tooMuchSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(2)).toString());

        tooMuchSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int hours = wakeUpTimesArray.get(2).getHours();
                int minutes = wakeUpTimesArray.get(2).getMinutes();

                Intent setAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
                setAlarm.putExtra(AlarmClock.EXTRA_HOUR, hours);
                setAlarm.putExtra(AlarmClock.EXTRA_MINUTES,  minutes);
                startActivity(setAlarm);


            }
        });



    }
}