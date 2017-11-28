package com.example.incode8.weather.ui.setting;

import com.example.incode8.weather.data.api.IDataManager;
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


}
