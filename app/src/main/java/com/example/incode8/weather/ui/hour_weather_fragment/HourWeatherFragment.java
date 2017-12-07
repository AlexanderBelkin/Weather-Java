package com.example.incode8.weather.ui.hour_weather_fragment;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.incode8.weather.R;
import com.example.incode8.weather.adapter.HourWeather.HourWeatherRecyclerAdpter;
import com.example.incode8.weather.di.component.ActivityComponent;
import com.example.incode8.weather.models.daily_model.Daily;
import com.example.incode8.weather.models.daily_model.DailyModelUi;
import com.example.incode8.weather.models.daily_model.WeatherDailyParametr;
import com.example.incode8.weather.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourWeatherFragment extends BaseFragment implements IHourWeatherView {

    public static String TAG = "HourWeatherFragment";
    private static int position;
    private HourWeatherRecyclerAdpter hourWeatherRecyclerAdpter;
    private Daily daily = new Daily();
    private WeatherDailyParametr weatherDailyParametr = new WeatherDailyParametr();

    @BindView(R.id.recyclerViewHourWeather)
    RecyclerView recyclerViewHour;

    @BindView(R.id.pressure_data_daily)
    TextView pressureDataDaily;

    @BindView(R.id.humidity_data_daily)
    TextView humidityDataDaily;

    @BindView(R.id.wind_data_daily)
    TextView windDataDaily;

    @BindView(R.id.cloudiness_data_daily)
    TextView cloudinessDataDaily;

    @Inject
    IHourWeatherPresenter<IHourWeatherView> mPresenter;

    public HourWeatherFragment() {
        // Required empty public constructor
    }

    public static HourWeatherFragment newInstance(int positionItem) {
        Bundle args = new Bundle();
        position = positionItem;
        HourWeatherFragment fragment = new HourWeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hour_weather, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        daily = DailyModelUi.listDaily.get(position);
        weatherDailyParametr = daily.dailyParametrs.get(0);
        recyclerViewHour.setLayoutManager(new LinearLayoutManager(view.getContext()));
        hourWeatherRecyclerAdpter = new HourWeatherRecyclerAdpter(getContext(), daily.forecastParametrs);
        recyclerViewHour.setAdapter(hourWeatherRecyclerAdpter);
        pressureDataDaily.setText(weatherDailyParametr.pressureDaily + " hPa");
        humidityDataDaily.setText(weatherDailyParametr.humidityDaily + " %");
        windDataDaily.setText(weatherDailyParametr.windDaily + " " + getString(R.string.km));
        cloudinessDataDaily.setText(weatherDailyParametr.cloudinessDaily + " %");
        return view;
    }

    @Override
    public void onError(String errorString) {

    }

    @Override
    public void onError(@StringRes int idRes) {

    }

    @Override
    public boolean networkConnected() {
        return false;
    }

    @Override
    protected void setUp(View view) {

    }
}
