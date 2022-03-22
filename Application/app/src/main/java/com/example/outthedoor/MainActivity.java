package com.example.outthedoor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView time = (TextView) findViewById(R.id.time);

        Date currentTime = new Date();
        String currentDateTimeString = DateFormat.getTimeInstance(DateFormat.SHORT).format(currentTime);

        time.setText(currentDateTimeString);

    }
}