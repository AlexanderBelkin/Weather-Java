package com.example.incode8.weather.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.incode8.weather.di.ActivityContext;
import com.example.incode8.weather.di.PreActivity;
import com.example.incode8.weather.ui.weather.IWeatherPresenter;
import com.example.incode8.weather.ui.weather.IWeatherView;
import com.example.incode8.weather.ui.weather.WeatherPresenter;
import com.example.incode8.weather.utils.rx.AppSchedulerProvider;
import com.example.incode8.weather.utils.rx.ISchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by incode8 on 08.08.17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return  mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() { return new CompositeDisposable(); }

    @Provides
    ISchedulerProvider provideSchedulerProvide() {return new AppSchedulerProvider(); }

    @Provides
    @PreActivity
    IWeatherPresenter<IWeatherView> provideWeatherPresenter(
            WeatherPresenter<IWeatherView> presenter ){
        return presenter;
    }
}
