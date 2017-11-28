package com.example.incode8.weather.ui.weather;

import com.example.incode8.weather.data.api.IDataManager;
import com.example.incode8.weather.ui.base.BasePresenter;
import com.example.incode8.weather.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by incode8 on 08.08.17.
 */

public class WeatherPresenter<V extends IWeatherView> extends BasePresenter<V>
        implements IWeatherPresenter<V>{

    @Inject
    public WeatherPresenter(ISchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable,
                            IDataManager dataManager){
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }
}
