package com.example.incode8.weather.ui.splash;

import com.example.incode8.weather.models.forecast_model.ForecastUI;
import com.example.incode8.weather.models.weather_model.WeatherUi;
import com.example.incode8.weather.ui.base.IBaseView;

/**
 * Created by incode8 on 10.08.17.
 */

public interface ISplashView extends IBaseView {
    void successWeather(WeatherUi weatherUi);

    void successForecast(ForecastUI forecastUI);
}
