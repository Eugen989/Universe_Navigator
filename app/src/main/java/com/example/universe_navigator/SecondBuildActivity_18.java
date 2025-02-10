package com.example.universe_navigator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondBuildActivity_18 extends AppCompatActivity {
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_building_18);

        imgView = findViewById(R.id.imgPlan_18);

        Log.e("SecondBuild", "Hello");
    }


    public void changeOfFloor(View view) {
        int buttonId = view.getId();
        String buttonName = getResources().getResourceEntryName(buttonId);
        char floorNumber = buttonName.charAt(buttonName.length() - 1);



        Log.e("SecondBuild", "Нажата кнопка: " + buttonName);

        switch (floorNumber) {
            case '1':
                imgView.setImageResource(R.drawable.housing_2_18_1);
                break;
            case '2':
                imgView.setImageResource(R.drawable.housing_2_18_2);
                break;
            case '3':
                imgView.setImageResource(R.drawable.housing_2_18_3);
                break;
            case '4':
                imgView.setImageResource(R.drawable.housing_2_18_4);
                break;
            case '5':
                imgView.setImageResource(R.drawable.housing_2_18_5);
                break;
        }
    }

}