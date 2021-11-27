package com.example.mylib;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;


import com.github.kss.activities.Activities;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MainActivity activity = (MainActivity) Activities.getPreviousActivity();
        List<Activity> activityList = Activities.getActivities();
        int i =0;
    }
}