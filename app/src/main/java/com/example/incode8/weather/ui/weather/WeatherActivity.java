package com.example.incode8.weather.ui.weather;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.incode8.weather.R;
import com.example.incode8.weather.ui.base.BaseActivity;
import com.example.incode8.weather.ui.setting.SettingActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeatherActivity extends BaseActivity implements IWeatherView{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Inject
    IWeatherPresenter<IWeatherView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, WeatherActivity.class);
        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        getActivityComponents().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(WeatherActivity.this);
    }

    @OnClick(R.id.action_settings)
    void Setting(View v){
        Intent intent = SettingActivity.getStartIntent(WeatherActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

}
