package com.example.javaweatherapph5;

import com.example.javaweatherapph5.models.WeatherItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IWeatherService {
    @GET("forecast")
    Call<WeatherItem> getWeatherByLatLon(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String appid);
}

//public interface IWeatherService {
//    @GET("forecast?lat={lat}&lon={lon}&appid={API_key}")
//    Call<Weather> getWeatherByLatLon(@Path("lat") double lat, @Path("lon") double lon, @Path("API_key") String API_key);
//}
