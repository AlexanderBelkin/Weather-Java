package com.example.incode8.weather.ui.weather;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incode8.weather.R;
import com.example.incode8.weather.mapper.ImageMapper;
import com.example.incode8.weather.models.weather_model.WeatherUi;
import com.example.incode8.weather.ui.base.BaseActivity;
import com.example.incode8.weather.ui.day_fragment.DayFragment;
import com.example.incode8.weather.ui.setting.SettingActivity;
import com.example.incode8.weather.ui.three_days.ThreeDaysFragment;
import com.example.incode8.weather.ui.week_fragment.WeekFragment;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeatherActivity extends BaseActivity implements IWeatherView{

    @BindView(R.id.cities_name)
    TextView citiesNameTextView;

    @BindView(R.id.temperature)
    TextView temperatureTextView;

    @BindView(R.id.clouds)
    TextView cloudsTextView;

    @BindView(R.id.cloudsIcon)
    ImageView cloudsImageView;

    @BindView(R.id.more_setting)
    ImageButton moreImageButton;

    @Inject
    IWeatherPresenter<IWeatherView> mPresenter;

    public static ArrayList<String> pref = new ArrayList<>();
    private Typeface typeface;
    private AdView mAdView;

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
        initAds();
        initComponent();
    }

    private void initAds() {
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-3940256099942544~3347511713");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.i("Ads", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("Ads", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.i("Ads", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("Ads", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.i("Ads", "onAdClosed");
            }
        });
    }

    @Override
    public void initComponent() {
        pref.clear();
        pref = mPresenter.getUserPreference(this);
        ImageMapper imageMapper = new ImageMapper(getTime());
        String fontPath = "fonts/CenturyGothicRegular.ttf";
        typeface = Typeface.createFromAsset(getAssets(), fontPath);
        citiesNameTextView.setTypeface(typeface);
        temperatureTextView.setTypeface(typeface);
        cloudsTextView.setTypeface(typeface);
        if(pref.get(0).equals("c")){
            temperatureTextView.setText(WeatherUi.temperature
                    + "\u00B0");
        }
        else {
            Integer temperature = Integer.parseInt(WeatherUi.temperature) * 9 / 5 + 32;
            temperatureTextView.setText(temperature
                    + "\u00B0");
        }
        cloudsTextView.setText(WeatherUi.clouds);

        cloudsImageView.setImageResource(imageMapper.setImage(WeatherUi.icon));
        switch (pref.get(1)){
            case "day":
                showDayFragment();
                break;
            case "threeDay":
                showThreeDayskFragment();
                break;
            case "week":
                showWeekFragment();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public int getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH");
        return Integer.parseInt(mdformat.format(calendar.getTime()));
    }

    @Override
    public void showDayFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.weather_frame, DayFragment.newInstance(), DayFragment.TAG)
                .commit();
    }

    @Override
    public void showWeekFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.weather_frame, WeekFragment.newInstance(), WeekFragment.TAG)
                .commit();
    }

    @Override
    public void showThreeDayskFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.weather_frame, ThreeDaysFragment.newInstance(), ThreeDaysFragment.TAG)
                .commit();
    }

    @OnClick(R.id.more_setting)
    void onMoreSetting(View v){
        Intent intent = SettingActivity.getStartIntent(WeatherActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
