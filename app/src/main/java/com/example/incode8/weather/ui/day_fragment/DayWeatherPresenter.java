package com.example.incode8.weather.ui.day_fragment;

import com.example.incode8.weather.data.IDataManager;
import com.example.incode8.weather.ui.base.BasePresenter;
import com.example.incode8.weather.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by incode8 on 11.08.17.
 */

public class DayWeatherPresenter<V extends IDayWeatherView> extends BasePresenter<V>
        implements IDayWeatherPresenter<V>{

    @Inject
    public DayWeatherPresenter(ISchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, IDataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }
}
