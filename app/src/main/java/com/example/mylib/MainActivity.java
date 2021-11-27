package com.example.mylib;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.kss.activities.Activities;
import com.github.kss.activities.ActivitiesListener;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Activities.init(this);
    }

    public void btn_click(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Activities.release();
    }
}