package com.example.incode8.weather.ui.day_fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.incode8.weather.R;
import com.example.incode8.weather.di.component.ActivityComponent;
import com.example.incode8.weather.models.weather_model.WeatherUi;
import com.example.incode8.weather.ui.base.BaseFragment;
import com.example.incode8.weather.ui.weather.WeatherActivity;

import java.text.DecimalFormat;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends BaseFragment implements IDayWeatherView {

    public static final String TAG = "AboutFragment";

    @BindView(R.id.pressure_data)
    TextView pressureTextView;

    @BindView(R.id.humidity_data)
    TextView humidityTextView;

    @BindView(R.id.wind_data)
    TextView windTextView;

    @BindView(R.id.cloudiness_data)
    TextView cloudinessTextView;

    @Inject
    IDayWeatherPresenter<IDayWeatherView> mPresenter;

    private Typeface typeface;

    public DayFragment() {
        // Required empty public constructor
    }

    public static DayFragment newInstance() {
        Bundle args = new Bundle();
        DayFragment fragment = new DayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day, container, false);

       ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        String fontPath = "fonts/CenturyGothicRegular.ttf";
        typeface = Typeface.createFromAsset(getActivity().getAssets(), fontPath);
        initComp();
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

    @Override
    public void initComp() {
        pressureTextView.setTypeface(typeface);
        humidityTextView.setTypeface(typeface);
        windTextView.setTypeface(typeface);
        cloudinessTextView.setTypeface(typeface);
        pressureTextView.setText(WeatherUi.pressure + " hPa");
        humidityTextView.setText(WeatherUi.humidity + " %");
        if(WeatherActivity.pref.get(2).equals(getContext().getString(R.string.km))) {
            windTextView.setText(WeatherUi.wind + " " + getActivity().getString(R.string.km));
        }else {
            Double wind = Double.parseDouble(WeatherUi.wind) * 0.44704;
            windTextView.setText(new DecimalFormat("#0.00").format(wind) + " " + getActivity().getString(R.string.mi));
        }
        cloudinessTextView.setText(WeatherUi.cloudiness + " %");
    }

}
