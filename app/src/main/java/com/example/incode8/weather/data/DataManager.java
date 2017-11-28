package com.example.incode8.weather.data;

import com.example.incode8.weather.data.api.IDataManager;
import com.example.incode8.weather.data.api.WeatherApi;
import com.example.incode8.weather.mapper.ForecastMapper;
import com.example.incode8.weather.mapper.WeatherMapper;
import com.example.incode8.weather.models.forecast_model.ForecastUI;
import com.example.incode8.weather.models.forecast_model.ForecastdData;
import com.example.incode8.weather.models.weather_model.WeatherData;
import com.example.incode8.weather.models.weather_model.WeatherUi;

import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;

import static com.example.incode8.weather.utils.AppConstants.APP_ID;
import static com.example.incode8.weather.utils.AppConstants.LANG;
import static com.example.incode8.weather.utils.AppConstants.UNITS;

/**
 * Created by incode8 on 10.08.17.
 */

public class DataManager implements IDataManager {

    private WeatherApi apiService;
    private static Observable<WeatherData> observableRetrofit;
    private static BehaviorSubject<WeatherData> observableModelsList;
    private static Subscription subscription;

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
    public Observable<ForecastUI> getDataWeatherForecast() {
        return apiService.getDataForecast("Kiev", UNITS, LANG, APP_ID)
                .map(new Function<ForecastdData, ForecastUI>() {
                    @Override
                    public ForecastUI apply(@NonNull ForecastdData weatherData) throws Exception {
                        return ForecastMapper.map(weatherData);
                    }
                });
    }
}
