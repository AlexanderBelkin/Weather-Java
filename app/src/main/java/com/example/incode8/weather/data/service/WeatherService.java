package com.example.incode8.weather.data.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WeatherService {

    private static String BASE_URL =  "http://api.openweathermap.org/";

    public IWeather getAPI(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(IWeather.class);
    }
}
