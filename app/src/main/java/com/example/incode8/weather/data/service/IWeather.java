package com.example.incode8.weather.data.service;

import com.example.incode8.weather.models.weather_model.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IWeather {
    @GET("/data/2.5/weather")
    Call<WeatherData> getData(@Query("q") String resourceName,
                              @Query("units") String units,
                              @Query("lang") String lang,
                              @Query("appid") String appid);
}