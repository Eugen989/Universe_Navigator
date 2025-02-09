package com.example.universe_navigator;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKit;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.runtime.image.ImageProvider;

public class MapActivity extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;
    private MapView mapview;
    private FusedLocationProviderClient fusedLocationClient;
    private MapObjectCollection mapObjects; // Коллекция объектов карты
    private PlacemarkMapObject userLocationMarker; // Маркер местоположения пользователя
    private Handler handler = new Handler();
    String buildingName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("ced98ea9-1d35-4c75-ae0c-f46aaa5bcc29");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);

        // Инициализируем mapview первым
        mapview = findViewById(R.id.mapview);
        mapObjects = mapview.getMap().getMapObjects().addCollection(); // Инициализируем mapObjects

        // Получаем название здания из Intent
        Intent intent = getIntent();
        buildingName = intent.getStringExtra("BUILDING_NAME");
        Log.e("Programmer", buildingName);

        // Добавляем маркеры только после инициализации mapObjects
        PlacemarkMapObject firstBuildLocationMarker = mapObjects.addPlacemark(new Point(53.249236f, 34.342387f),
                ImageProvider.fromResource(this, R.drawable.universe_marker));

        PlacemarkMapObject secondBuildLocationMarker = mapObjects.addPlacemark(new Point(53.243540f, 34.364818f),
                ImageProvider.fromResource(this, R.drawable.universe_marker));

        // Двигаем камеру на здание
        if ("First_Build".equals(buildingName))
            mapview.getMap().move(
                    new CameraPosition(new Point(53.249236f, 34.342387f), 18.0f, 0.0f, 0.0f),
                    new Animation(Animation.Type.SMOOTH, 2f),
                    null
            );
        else if ("Second_Build".equals(buildingName))
            mapview.getMap().move(
                    new CameraPosition(new Point(53.243540f, 34.364818f), 18.0f, 0.0f, 0.0f),
                    new Animation(Animation.Type.SMOOTH, 2f),
                    null
            );

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        UserLocationLayer locationMapKit = MapKitFactory.getInstance().createUserLocationLayer(mapview.getMapWindow());
        locationMapKit.setVisible(true);

        // Запросим разрешение на геолокацию
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    protected void onStop() {
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        handler.removeCallbacksAndMessages(null); // Останавливаем обновление местоположения
        super.onStop();
    }

    @Override
    protected void onStart() {
        mapview.onStart();
        MapKitFactory.getInstance().onStart();
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        MapKitFactory.getInstance().onStop();
        super.onDestroy();
    }
}
