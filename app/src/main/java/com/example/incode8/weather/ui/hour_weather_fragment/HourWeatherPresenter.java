package com.example.incode8.weather.ui.hour_weather_fragment;

import com.example.incode8.weather.data.IDataManager;
import com.example.incode8.weather.ui.base.BasePresenter;
import com.example.incode8.weather.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by incode8 on 15.08.17.
 */

public class HourWeatherPresenter<V extends IHourWeatherView> extends BasePresenter<V>
        implements IHourWeatherPresenter<V> {

    @Inject
    public HourWeatherPresenter(ISchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, IDataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

}
