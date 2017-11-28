package com.example.incode8.weather.data.api;

import com.example.incode8.weather.models.forecast_model.ForecastUI;
import com.example.incode8.weather.models.weather_model.WeatherUi;

import io.reactivex.Observable;


/**
 * Created by incode8 on 10.08.17.
 */

public interface IDataManager {

    Observable<WeatherUi> getDataWeatherNow();

    Observable<ForecastUI>  getDataWeatherForecast();
}
