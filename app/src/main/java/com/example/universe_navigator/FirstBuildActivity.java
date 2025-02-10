package com.example.universe_navigator;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstBuildActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView imageChildren;
    private FrameLayout frameMovingAria;
    private float dX, dY;
    private ScaleGestureDetector scaleGestureDetector;
    private float scale = 1f;
    private boolean isMoving = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_building); // Убедитесь, что здесь правильный файл разметки

        imageView = findViewById(R.id.imageView6);
        imageChildren = findViewById(R.id.imageView7);
        frameMovingAria = findViewById(R.id.frameMovingAria);

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                movingParent(view, event);
                if (event.getAction() == MotionEvent.ACTION_UP && !isMoving) {
                    Log.e("ImageView", "Tapped");
                }
                return true;
            }
        });

        // для ребёнка
        imageChildren.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                movingParent(view, event);
                if (event.getAction() == MotionEvent.ACTION_UP && !isMoving) {
                    Log.e("ImageChildren", "Click");
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
                frameMovingAria.setX(newX);
                frameMovingAria.setY(newY);

                break;
            default:
                return;
        }
    }

    // Класс для обработки жестов масштабирования
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor(); // Изменение масштаба

            // Ограничиваем масштаб
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            // Применение масштаба ко всем элементам внутри frameMovingAria
            for (int i = 0; i < frameMovingAria.getChildCount(); i++) {
                View child = frameMovingAria.getChildAt(i);
                child.setScaleX(scale);
                child.setScaleY(scale);
            }
            frameMovingAria.setScaleX(scale*2);
            frameMovingAria.setScaleY(scale*2);

            return true;
        }
    }

}
