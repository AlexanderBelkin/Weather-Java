package com.example.incode8.weather.ui.setting;

import android.app.Activity;

import com.example.incode8.weather.data.IDataManager;
import com.example.incode8.weather.ui.base.BasePresenter;
import com.example.incode8.weather.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by incode8 on 09.08.17.
 */

public class SettingPresenter<V extends ISettingView> extends BasePresenter<V>
        implements ISettingPresenter<V> {

    @Inject
    public SettingPresenter(ISchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable,
                            IDataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }


    @Override
    public void setUserFrequency(Activity activity, String frequency) {
        getDataManager().setUserFrequency(activity, frequency);
    }

    @Override
    public void setUserTemperature(Activity activity, String temperature) {
        getDataManager().setUserTemperature(activity, temperature);
    }

    @Override
    public void setUserSpeed(Activity activity, String speed) {
        getDataManager().setUserSpeed(activity, speed);
    }


}
