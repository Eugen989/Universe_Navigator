package com.example.universe_navigator;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondBuildActivity_18 extends AppCompatActivity {
    private ImageView imgView;
    private ScaleGestureDetector scaleGestureDetector;

    private float dX, dY;
    private float scale = 1f;
    private boolean isMoving = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_building_18);

        imgView = findViewById(R.id.imgPlan_18);

        scaleGestureDetector = new ScaleGestureDetector(this, new SecondBuildActivity_18.ScaleListener());

        imgView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                movingParent(view, event);
                if (event.getAction() == MotionEvent.ACTION_UP && !isMoving) {
                    Log.e("ImageView", "Tapped");
                }
                return true;
            }
        });
    }

    protected void movingParent (View view, MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                dX = view.getX() - event.getRawX();
                dY = view.getY() - event.getRawY();
                isMoving = false;
                break;

            case MotionEvent.ACTION_MOVE:
                isMoving = true;
                float newX = event.getRawX();
                float newY = event.getRawY();
                imgView.setX(newX);
                imgView.setY(newY);

                break;
            default:
                return;
        }
    }

    protected class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();

            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            imgView.setScaleX(scale);
            imgView.setScaleY(scale);

            return true;
        }
    }


    public void changeOfFloor(View view) {
        int buttonId = view.getId();
        String buttonName = getResources().getResourceEntryName(buttonId);
        char floorNumber = buttonName.charAt(buttonName.length() - 1);



        Log.e("SecondBuild", "Нажата кнопка: " + buttonName);

        switch (floorNumber) {
            case '0':
                imgView.setImageResource(R.drawable.housing_2_18_0);
                break;
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