package com.example.universe_navigator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.universe_navigator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mainHeader.navBtnBgitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Header button clicked!");
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        binding.mainHeader.navBtnHowtoget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlacesListActivity.class);
                startActivity(intent);
            }
        });
    }


    public void linkFirstBuild(View view) {
        Intent intent = new Intent(MainActivity.this, FirstBuildActivity.class);
        startActivity(intent);
    }

    public void linkSecondDrawingBuildArea(View view) {
        Intent intent = new Intent(MainActivity.this, SecondBuildingAreaActivity.class);
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