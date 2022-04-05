package com.example.outthedoor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView time = findViewById(R.id.time);

        Date currentTime = new Date();
        String currentDateTimeString = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime); //current time for clock display

        time.setText(currentDateTimeString); //sets current time in app

        Button sleepingNowButton = findViewById(R.id.sleepingNowButton);
        sleepingNowButton.setOnClickListener( new View.OnClickListener(){


            private static final int HOUR = 3600*1000; //hour in ms

            public ArrayList<Date> calculateWakeTime(Date currentTime){

                ArrayList<Date> riseTimes = new ArrayList<>(); //arraylist containing potential wake up times

                Date riseTime1 = new Date(currentTime.getTime() + 6 * HOUR);
                riseTimes.add(riseTime1);
                Date riseTime2 = new Date((long) (currentTime.getTime() + 7.5 * HOUR)); //optimal wake up
                riseTimes.add(riseTime2);
                Date riseTime3 = new Date(currentTime.getTime() + 9 * HOUR);
                riseTimes.add(riseTime3);


                return riseTimes;
            }


            @Override
            public void onClick(View v){

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    Bundle bundle = new Bundle();
                    ArrayList<Date> wakeUpTimesArray = calculateWakeTime(currentTime);
                    bundle.putSerializable("wakeUpTimesArray", wakeUpTimesArray);
                    intent.putExtras(bundle);
                    startActivity(intent);



            }


        });






    }
}