package com.example.javaweatherapph5;

import android.util.Log;

import com.example.javaweatherapph5.models.WeatherItem;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import retrofit2.Call;

public class ApiLayer {
    public static WeatherItem getWeatherByLatLon(double lat, double lon, String API_key) {
        FutureTask<WeatherItem> futureTask = new FutureTask<>(new Callable<WeatherItem>() {
            @Override
            public WeatherItem call() {
                WeatherItem f = null;
                IWeatherService service = ServiceBuilder.buildService(IWeatherService.class);
                Call<WeatherItem> request = service.getWeatherByLatLon(lat, lon, API_key);
                try {
                    f = request.execute().body(); // The call happens in a new thread
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return f;
            }
        });
        Thread t = new Thread(futureTask);
        t.start();
        WeatherItem weather = null;
        try {
            weather = futureTask.get(); // will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }
        return weather;
    }
}
