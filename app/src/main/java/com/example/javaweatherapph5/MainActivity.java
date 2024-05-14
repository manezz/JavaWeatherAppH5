package com.example.javaweatherapph5;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.javaweatherapph5.models.WeatherItem;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    WeatherItem weather;
    TextView tv_currentDay1stView, tv_currentDay2stView, tv_currentDay3stView, tv_currentDay4stView, tv_currentDay5stView;
    TextView tv_tempDay2, tv_tempMinDay2, tv_tempMaxDay2, tv_CloudsDay2, tv_RainProbDay2;

    TextView tv_tempDay3, tv_tempMinDay3, tv_tempMaxDay3, tv_CloudsDay3, tv_RainProbDay3;
    TextView tv_tempDay4, tv_tempMinDay4, tv_tempMaxDay4, tv_CloudsDay4, tv_RainProbDay4;
    TextView tv_tempDay5, tv_tempMinDay5, tv_tempMaxDay5, tv_CloudsDay5, tv_RainProbDay5;

    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request the missing permissions
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
        } else {
            // Permissions are already granted, continue with your logic
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                                double lat = location.getLatitude();
                                double lon = location.getLongitude();
                                String ApiEnvKey = System.getenv("API_EnvKey_JavaWeatherAppH5");
                                weather = ApiLayer.getWeatherByLatLon(lat, lon, ApiEnvKey);
                            }
                        }
                    });
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                            double lat = location.getLatitude();
                            double lon = location.getLongitude();
                            //String ApiEnvKey = System.getenv("API_EnvKey_JavaWeatherAppH5");
                            String ApiEnvKey = "";
                            weather = ApiLayer.getWeatherByLatLon(lat, lon, ApiEnvKey);
                        }
                    }
                });
        tv_currentDay1stView = findViewById(R.id.tv_currentDay1stView);
        tv_currentDay2stView = findViewById(R.id.tv_currentDay2stView);
        tv_currentDay3stView = findViewById(R.id.tv_currentDay3stView);
        tv_currentDay4stView = findViewById(R.id.tv_currentDay4stView);
        tv_currentDay5stView = findViewById(R.id.tv_currentDay5stView);

        tv_tempDay2 = findViewById(R.id.tv_tempDay2);
        tv_tempMinDay2 = findViewById(R.id.tv_tempMinDay2);
        tv_tempMaxDay2 = findViewById(R.id.tv_tempMaxDay2);
        tv_CloudsDay2 = findViewById(R.id.tv_CloudsDay2);
        tv_RainProbDay2 = findViewById(R.id.tv_RainProbDay2);

        tv_tempDay3 = findViewById(R.id.tv_tempDay3);
        tv_tempMinDay3 = findViewById(R.id.tv_tempMinDay3);
        tv_tempMaxDay3 = findViewById(R.id.tv_tempMaxDay3);
        tv_CloudsDay3 = findViewById(R.id.tv_CloudsDay3);
        tv_RainProbDay3 = findViewById(R.id.tv_RainProbDay3);

        tv_tempDay4 = findViewById(R.id.tv_tempDay4);
        tv_tempMinDay4 = findViewById(R.id.tv_tempMinDay4);
        tv_tempMaxDay4 = findViewById(R.id.tv_tempMaxDay4);
        tv_CloudsDay4 = findViewById(R.id.tv_CloudsDay4);
        tv_RainProbDay4 = findViewById(R.id.tv_RainProbDay4);

        tv_tempDay5 = findViewById(R.id.tv_tempDay5);
        tv_tempMinDay5 = findViewById(R.id.tv_tempMinDay5);
        tv_tempMaxDay5 = findViewById(R.id.tv_tempMaxDay5);
        tv_CloudsDay5 = findViewById(R.id.tv_CloudsDay5);
        tv_RainProbDay5 = findViewById(R.id.tv_RainProbDay5);

        tv_currentDay1stView.setText(weather.list.get(0).weather.get(0).description);
    }
}