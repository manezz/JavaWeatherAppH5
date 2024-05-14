package com.example.javaweatherapph5;

import android.util.Log;

import com.example.javaweatherapph5.models.Weather;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import retrofit2.Call;

public class ApiLayer {
    public static Weather getWeatherByLatLon(String lat, String lon, String API_key) {
        FutureTask<Weather> futureTask = new FutureTask<>(new Callable<Weather>() {
            @Override
            public Weather call() {
                Weather f = null;
                IWeatherService service = ServiceBuilder.buildService(IWeatherService.class);
                Call<Weather> request = service.getWeatherByLatLon(lat, lon, API_key);
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
        Weather weather = null;
        try {
            weather = futureTask.get(); // will wait for the async completion
        } catch (Exception e) {
            Log.d("Thread", e.getMessage());
        }
        return weather;
    }
}
