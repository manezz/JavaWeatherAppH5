package com.example.javaweatherapph5;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {
    private static final String URL = "api.openweathermap.org/data/2.5/";

    private static Retrofit retrofit =
            new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
    public static <F> F buildService(Class<F> serviceType)
    {
        return retrofit.create(serviceType);
    }

}