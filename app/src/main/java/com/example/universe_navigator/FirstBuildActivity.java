package com.example.universe_navigator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class FirstBuildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_building);
    }

    public void linkFirstBuild(View view) {
        Intent intent = new Intent(FirstBuildActivity.this, MapActivity.class);
        intent.putExtra("BUILDING_NAME", "Первое Здание"); // Передаем название первого здания
        startActivity(intent);
    }

    public void linkSecondBuild(View view) {
        Intent intent = new Intent(FirstBuildActivity.this, MapActivity.class);
        intent.putExtra("BUILDING_NAME", "Второе Здание"); // Передаем название второго здания
        startActivity(intent);
    }
}
