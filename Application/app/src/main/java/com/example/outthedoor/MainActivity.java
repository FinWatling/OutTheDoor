package com.example.outthedoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView time = findViewById(R.id.time);

        Date currentTime = new Date();
        String currentDateTimeString = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime);

        time.setText(currentDateTimeString);

        Button sleepingNowButton = findViewById(R.id.sleepingNowButton);
        sleepingNowButton.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Intent setAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
                setAlarm.putExtra(AlarmClock.EXTRA_HOUR, 8);
                setAlarm.putExtra(AlarmClock.EXTRA_MINUTES, 30);
                startActivity(setAlarm);

            }


        });

    }
}