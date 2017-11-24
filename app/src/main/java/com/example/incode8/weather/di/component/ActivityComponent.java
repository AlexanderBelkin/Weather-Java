package com.example.incode8.weather.di.component;

import com.example.incode8.weather.di.PreActivity;
import com.example.incode8.weather.di.module.ActivityModule;
import com.example.incode8.weather.ui.setting.SettingActivity;
import com.example.incode8.weather.ui.weather.WeatherActivity;

import dagger.Component;

/**
 * Created by incode8 on 08.08.17.
 */

@PreActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(WeatherActivity activity);

    void inject(SettingActivity activity);

}
