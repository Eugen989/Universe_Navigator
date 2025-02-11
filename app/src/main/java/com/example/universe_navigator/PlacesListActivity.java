package com.example.universe_navigator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.universe_navigator.databinding.ActivityMainBinding;

public class PlacesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_list_activity);

        com.example.universe_navigator.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void linkFirstBuild(View view) {
        Intent intent = new Intent(PlacesListActivity.this, MapActivity.class);
        intent.putExtra("BUILDING_NAME", "First_Build"); // Передаем название первого здания
        startActivity(intent);
    }

    public void linkSecondBuild(View view) {
        Intent intent = new Intent(PlacesListActivity.this, MapActivity.class);
        intent.putExtra("BUILDING_NAME", "Second_Build"); // Передаем название второго здания
        startActivity(intent);
    }
}
