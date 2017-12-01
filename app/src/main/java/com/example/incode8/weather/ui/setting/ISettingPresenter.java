package com.example.incode8.weather.ui.setting;

import android.app.Activity;

import com.example.incode8.weather.ui.base.IBasePresenter;

/**
 * Created by incode8 on 09.08.17.
 */

public interface ISettingPresenter<V extends ISettingView> extends IBasePresenter<V> {

    void setUserFrequency(Activity activity, String frequency);

    void setUserTemperature(Activity activity, String temperature);

    void setUserSpeed(Activity activity, String speed);
}
