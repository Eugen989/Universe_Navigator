package com.example.universe_navigator;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FirstBuildActivity extends AppCompatActivity {

    private ImageView imageView;
    private float dX, dY;
    private ScaleGestureDetector scaleGestureDetector;
    private float scale = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_building); // Убедитесь, что здесь правильный файл разметки

        imageView = findViewById(R.id.imageView6);

        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                scaleGestureDetector.onTouchEvent(event); // Обработка жестов масштабирования

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        dX = view.getX() - event.getRawX();
                        dY = view.getY() - event.getRawY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        float newX = event.getRawX() + dX;
                        float newY = event.getRawY() + dY;

                        // Убедитесь, что ImageView не выходит за пределы экрана
                        if (newX >= 0 && newX <= ((View) view.getParent()).getWidth() - view.getWidth()) {
                            view.setX(newX);
                        }

                        if (newY >= 0 && newY <= ((View) view.getParent()).getHeight() - view.getHeight()) {
                            view.setY(newY);
                        }
                        break;

                    default:
                        return false;
                }
                return true;
            }
        });
    }

    // Класс для обработки жестов масштабирования
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor(); // Изменение масштаба

            // Ограничиваем масштаб
            scale = Math.max(0.1f, Math.min(scale, 5.0f));

            imageView.setScaleX(scale);
            imageView.setScaleY(scale);

            return true;
        }
    }
}
