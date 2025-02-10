package com.example.universe_navigator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void linkFirstBuild(View view) {
        Intent intent = new Intent(MainActivity.this, FirstBuildActivity.class);
        startActivity(intent);
    }

    public void linkSecondDrawingBuild_18(View view) {
        Intent intent = new Intent(MainActivity.this, SecondBuildActivity_18.class);
        startActivity(intent);
    }

    public void linkSecondDrawingBuild_19(View view) {
        Intent intent = new Intent(MainActivity.this, SecondBuildActivity_19.class);
        startActivity(intent);
    }

    public void linkToMap(View view) {
        Intent intent = new Intent(MainActivity.this, PlacesListActivity.class);
        startActivity(intent);
    }
}