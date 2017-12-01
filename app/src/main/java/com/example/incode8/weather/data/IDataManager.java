package com.example.incode8.weather.data;

import android.app.Activity;

import com.example.incode8.weather.data.user_setting.IUserSetting;
import com.example.incode8.weather.models.daily_model.DailyModelUi;
import com.example.incode8.weather.models.forecast_model.ForecastUi;
import com.example.incode8.weather.models.weather_model.WeatherUi;

import java.util.ArrayList;

import io.reactivex.Observable;


/**
 * Created by incode8 on 10.08.17.
 */

public interface IDataManager extends IUserSetting {

    Observable<WeatherUi> getDataWeatherNow();

    Observable<ForecastUi>  getDataWeatherForecast();

    Observable<DailyModelUi> getDataWeatherDaily();

    @Override
    ArrayList<String> getSharedPreferences(Activity context);
}
