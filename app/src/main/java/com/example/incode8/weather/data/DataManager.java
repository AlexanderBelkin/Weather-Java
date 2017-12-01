package com.example.incode8.weather.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.incode8.weather.R;
import com.example.incode8.weather.data.api.WeatherApi;
import com.example.incode8.weather.data.user_setting.IUserSetting;
import com.example.incode8.weather.mapper.DailyMapper;
import com.example.incode8.weather.mapper.ForecastMapper;
import com.example.incode8.weather.mapper.WeatherMapper;
import com.example.incode8.weather.models.daily_model.DailyModel;
import com.example.incode8.weather.models.daily_model.DailyModelUi;
import com.example.incode8.weather.models.forecast_model.ForecastUi;
import com.example.incode8.weather.models.forecast_model.ForecastdData;
import com.example.incode8.weather.models.weather_model.WeatherData;
import com.example.incode8.weather.models.weather_model.WeatherUi;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

import static com.example.incode8.weather.utils.AppConstants.APP_ID;
import static com.example.incode8.weather.utils.AppConstants.LANG;
import static com.example.incode8.weather.utils.AppConstants.UNITS;

/**
 * Created by incode8 on 10.08.17.
 */

public class DataManager implements IDataManager, IUserSetting {

    private WeatherApi apiService;

    @Inject
    DataManager(WeatherApi retrofit) {
        this.apiService = retrofit;
    }

    @Override
    public Observable<WeatherUi> getDataWeatherNow() {
        return apiService.getDataWeather("Zaporizhzhia", UNITS, LANG, APP_ID)
                .map(new Function<WeatherData, WeatherUi>() {
                    @Override
                    public WeatherUi apply(@NonNull WeatherData weatherData) throws Exception {
                        return WeatherMapper.map(weatherData);
                    }
                });

    }

    @Override
    public Observable<ForecastUi> getDataWeatherForecast() {
        return apiService.getDataForecast("Zaporizhzhia", UNITS, LANG, APP_ID)
                .map(new Function<ForecastdData, ForecastUi>() {
                    @Override
                    public ForecastUi apply(@NonNull ForecastdData weatherData) throws Exception {
                        return ForecastMapper.map(weatherData);
                    }
                });
    }

    @Override
    public Observable<DailyModelUi> getDataWeatherDaily() {
        return apiService.getDataForecastDaily("Zaporizhzhia", UNITS, LANG, APP_ID)
                .map(new Function<DailyModel, DailyModelUi>() {
                    @Override
                    public DailyModelUi apply(@NonNull DailyModel dailyData) throws Exception {
                        return DailyMapper.map(dailyData);
                    }
                });
    }

    @Override
    public ArrayList<String> getSharedPreferences(Activity context) {
        ArrayList<String> userPrefference = new ArrayList<>();
        SharedPreferences sharedPref = context.getSharedPreferences( "setting_user", Context.MODE_PRIVATE);
        String defaultTemperature = "c";
        String defaultFrequency = "day";
        String defoultSpeed = "m/s";
        String temperature = sharedPref.getString(context.getString(R.string.temperature), defaultTemperature);
        String frequency = sharedPref.getString( "frequency", defaultFrequency);
        String speed = sharedPref.getString( context.getString(R.string.speed), defoultSpeed);
        userPrefference.add(temperature);
        userPrefference.add(frequency);
        userPrefference.add(speed);
        return userPrefference;
    }

    @Override
    public void setUserTemperature(Activity context, String temperature) {
        SharedPreferences sharedPref = context.getSharedPreferences( "setting_user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(R.string.temperature), temperature);
        editor.apply();
    }

    @Override
    public void setUserFrequency(Activity context, String frequency) {
        SharedPreferences sharedPref = context.getSharedPreferences( "setting_user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(R.string.frequency), frequency);
        editor.apply();
    }

    @Override
    public void setUserSpeed(Activity context, String speed) {
        SharedPreferences sharedPref = context.getSharedPreferences( "setting_user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getString(R.string.speed), speed);
        editor.apply();
    }

}
