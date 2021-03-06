package com.example.incode8.weather.ui.splash;

import android.app.Activity;

import com.example.incode8.weather.di.ActivityScope;
import com.example.incode8.weather.ui.base.IBasePresenter;

import java.util.ArrayList;

/**
 * Created by incode8 on 10.08.17.
 */

@ActivityScope
public interface ISplashPresenter<V extends ISplashView> extends IBasePresenter<V> {

    void getWeatherNow();

    void getWeatherForecast();

    void getWeatherForecastDaily();


}
