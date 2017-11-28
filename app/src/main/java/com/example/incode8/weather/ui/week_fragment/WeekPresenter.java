package com.example.incode8.weather.ui.week_fragment;

import com.example.incode8.weather.data.api.IDataManager;
import com.example.incode8.weather.ui.base.BasePresenter;
import com.example.incode8.weather.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by incode8 on 11.08.17.
 */

public class WeekPresenter <V extends IWeekView> extends BasePresenter<V>
        implements IWeekPresenter<V>{

    @Inject
    public WeekPresenter(ISchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable, IDataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }
}

