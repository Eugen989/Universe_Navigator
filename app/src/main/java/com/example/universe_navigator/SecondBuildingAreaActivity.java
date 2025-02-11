package com.example.universe_navigator;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondBuildingAreaActivity extends AppCompatActivity {
    private ImageView imgView;
    private ScaleGestureDetector scaleGestureDetector;

    private float dX, dY;
    private float scale = 1f;
    private boolean isMoving = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_building_area);


        imgView = findViewById(R.id.imgPlan);

        scaleGestureDetector = new ScaleGestureDetector(this, new SecondBuildingAreaActivity.ScaleListener());

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

}