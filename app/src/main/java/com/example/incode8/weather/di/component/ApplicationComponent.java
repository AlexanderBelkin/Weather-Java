package com.example.incode8.weather.di.component;

import android.app.Application;
import android.content.Context;

import com.example.incode8.weather.WeatherApplication;
import com.example.incode8.weather.data.api.IDataManager;
import com.example.incode8.weather.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by incode8 on 08.08.17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(WeatherApplication app);

    Context context();

    IDataManager dataManager();

    Application application();
}
