package com.example.incode8.weather.ui.weather;

import com.example.incode8.weather.di.PreActivity;
import com.example.incode8.weather.ui.base.IBasePresenter;

/**
 * Created by incode8 on 08.08.17.
 */

@PreActivity
public interface IWeatherPresenter<V extends IWeatherView> extends IBasePresenter<V> {

    void getDataWeatherNow();

    void getDataWeatherForecast();

}
