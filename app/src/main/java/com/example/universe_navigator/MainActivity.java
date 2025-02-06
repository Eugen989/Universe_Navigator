package com.example.universe_navigator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    public void linkSecondBuild(View view) {
        Intent intent = new Intent(MainActivity.this, SecondBuildActivity.class);
        startActivity(intent);
    }

    public void linkToMap(View view) {
        Intent intent = new Intent(MainActivity.this, PlacesListActivity.class);
        startActivity(intent);
    }
}