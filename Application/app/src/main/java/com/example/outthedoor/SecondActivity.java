package com.example.outthedoor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

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

        System.out.println(wakeUpTimesArray + "From Second Activity");

    }
}