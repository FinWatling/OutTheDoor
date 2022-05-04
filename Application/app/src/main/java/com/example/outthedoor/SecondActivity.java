package com.example.outthedoor;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_second);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<Date> wakeUpTimesArray;
        TextView time = findViewById(R.id.time);

        String activityCheck = intent.getExtras().getString("fromID"); //checking which activity launched this

        if(activityCheck.equals("MainActivity")) {

            wakeUpTimesArray = (ArrayList<Date>) bundle.getSerializable("wakeUpTimesArrayFromMainActivity");
            Date currentTime = new Date();
            String currentDateTimeString = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime); //current time for clock display
            time.setText(currentDateTimeString);

        }else{

            wakeUpTimesArray = (ArrayList<Date>) bundle.getSerializable("wakeUpTimesArrayFromSleepingSoonActivity");
            Date timeOfSleep = (Date) bundle.get("TimeOfSleep");
            String timeOfSleepString = DateFormat.getTimeInstance(DateFormat.SHORT).format(timeOfSleep);
            time.setText(timeOfSleepString);

        }



        Button leastSleep = findViewById(R.id.leastSleep);
        leastSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(0)));

        leastSleep.setOnClickListener(view -> {

            int hours = wakeUpTimesArray.get(0).getHours();
            int minutes = wakeUpTimesArray.get(0).getMinutes();

            Intent setAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
           setAlarm.putExtra(AlarmClock.EXTRA_HOUR, hours);
           setAlarm.putExtra(AlarmClock.EXTRA_MINUTES,  minutes);
           startActivity(setAlarm);


        });

        Button bestSleep = findViewById(R.id.bestSleep);
        bestSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(1)));

        bestSleep.setOnClickListener(view -> {

            int hours = wakeUpTimesArray.get(1).getHours();
            int minutes = wakeUpTimesArray.get(1).getMinutes();

            Intent setAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
            setAlarm.putExtra(AlarmClock.EXTRA_HOUR, hours);
            setAlarm.putExtra(AlarmClock.EXTRA_MINUTES,  minutes);
            startActivity(setAlarm);


        });

        Button tooMuchSleep = findViewById(R.id.tooMuchSleep);
        tooMuchSleep.setText(DateFormat.getTimeInstance(DateFormat.SHORT).format(wakeUpTimesArray.get(2)));

        tooMuchSleep.setOnClickListener(view -> {

            int hours = wakeUpTimesArray.get(2).getHours();
            int minutes = wakeUpTimesArray.get(2).getMinutes();

            Intent setAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
            setAlarm.putExtra(AlarmClock.EXTRA_HOUR, hours);
            setAlarm.putExtra(AlarmClock.EXTRA_MINUTES,  minutes);
            startActivity(setAlarm);


        });



    }
}