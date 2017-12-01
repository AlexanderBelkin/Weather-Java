package com.example.incode8.weather.data.api;

import com.example.incode8.weather.models.daily_model.DailyModel;
import com.example.incode8.weather.models.forecast_model.ForecastdData;
import com.example.incode8.weather.models.weather_model.WeatherData;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.incode8.weather.utils.AppConstants.APP_ID_QEURY;
import static com.example.incode8.weather.utils.AppConstants.CITY_NAME;
import static com.example.incode8.weather.utils.AppConstants.LANG_QEURY;
import static com.example.incode8.weather.utils.AppConstants.QEURY_WEATHER;
import static com.example.incode8.weather.utils.AppConstants.QUERY_FORECAST;
import static com.example.incode8.weather.utils.AppConstants.QUERY_FORECAST_DAILY;
import static com.example.incode8.weather.utils.AppConstants.UNITS_QEURY;

/**
 * Created by incode8 on 09.08.17.
 */

public interface WeatherApi {

    @GET(QEURY_WEATHER)
    Observable<WeatherData> getDataWeather(@Query(CITY_NAME) String resourceName,
                                           @Query(UNITS_QEURY) String units,
                                           @Query(LANG_QEURY) String lang,
                                           @Query(APP_ID_QEURY) String appid);

    @GET(QUERY_FORECAST)
    Observable<ForecastdData> getDataForecast(@Query(CITY_NAME) String cityName,
                                              @Query(UNITS_QEURY) String units,
                                              @Query(LANG_QEURY) String lang,
                                              @Query(APP_ID_QEURY) String appid);

    @GET(QUERY_FORECAST_DAILY)
    Observable<DailyModel> getDataForecastDaily(@Query(CITY_NAME) String cityName,
                                                @Query(UNITS_QEURY) String units,
                                                @Query(LANG_QEURY) String lang,
                                                @Query(APP_ID_QEURY) String appid);
}
