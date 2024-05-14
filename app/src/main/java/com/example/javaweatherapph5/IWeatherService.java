package com.example.javaweatherapph5;

import com.example.javaweatherapph5.models.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IWeatherService {
    @GET("forecast?lat={lat}&lon={lon}&appid={API_key}")
    Call<Weather> getWeatherByLatLon(@Path("lat") double lat, @Path("lon") double lon, @Path("API key") String API_key);
}
