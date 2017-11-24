package com.example.incode8.weather.data.service;

import com.example.incode8.weather.models.forecast_model.ForecastdData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by igortovkach on 7/31/17.
 */

public interface IForecast {
    @GET("/data/2.5/forecast")
    Call<ForecastdData> getData(@Query("q") String cityName,
                                @Query("units") String units,
                                @Query("lang") String lang,
                                @Query("appid") String appid);
}