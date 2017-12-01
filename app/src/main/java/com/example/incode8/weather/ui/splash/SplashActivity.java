package com.example.incode8.weather.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.example.incode8.weather.R;
import com.example.incode8.weather.models.forecast_model.ForecastUi;
import com.example.incode8.weather.models.weather_model.WeatherUi;
import com.example.incode8.weather.ui.base.BaseActivity;
import com.example.incode8.weather.ui.weather.WeatherActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity implements ISplashView {

    @Inject
    ISplashPresenter<ISplashView> mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponents().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(SplashActivity.this);
    }

    @Override
    public void successWeather(WeatherUi weatherUi) {

    }

    @Override
    public void successForecast(ForecastUi forecastUi) {
        Intent intent = WeatherActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
