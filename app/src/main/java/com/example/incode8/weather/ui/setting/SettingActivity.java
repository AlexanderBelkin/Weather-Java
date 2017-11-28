package com.example.incode8.weather.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incode8.weather.R;
import com.example.incode8.weather.ui.base.BaseActivity;
import com.example.incode8.weather.ui.weather.WeatherActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.incode8.weather.R.id.cels;

public class SettingActivity extends BaseActivity implements ISettingView{

    @BindView(R.id.day_weather)
    TextView dayTextView;

    @BindView(R.id.week_weather)
    TextView weekTextView;

    @BindView(R.id.two_week_weather)
    TextView twoWeekTextView;

    @BindView(R.id.km_weater)
    TextView kmTextView;

    @BindView(R.id.mi_weater)
    TextView miTextView;

    @BindView(R.id.back_button)
    ImageButton backImageButton;

    @BindView(cels)
    ImageView celsTextView;

    @BindView(R.id.far)
    ImageView farTextView;

    Typeface typeface;

    @Inject
    ISettingPresenter<ISettingView> mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setUnBinder(ButterKnife.bind(this));
        onInitComponent();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        return intent;
    }

    @OnClick(R.id.back_button)
    void onBackButton(View v){
        Intent intent = WeatherActivity.getStartIntent(SettingActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onInitComponent() {
        String fontPath = "fonts/CenturyGothicRegular.ttf";
        typeface = Typeface.createFromAsset(getAssets(), fontPath);

        weekTextView.setTypeface(typeface);
        dayTextView.setTypeface(typeface);
        twoWeekTextView.setTypeface(typeface);
        kmTextView.setTypeface(typeface);
        miTextView.setTypeface(typeface);

    }

    @OnClick(R.id.day_weather)
    void setDay(View v){
        dayTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
        weekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        twoWeekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
    }

    @OnClick(R.id.week_weather)
    void setWeek(View v){
        dayTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        weekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
        twoWeekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
    }

    @OnClick(R.id.two_week_weather)
    void setTwoWeek(View v){
        dayTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        weekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        twoWeekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
    }

    @OnClick(R.id.km_weater)
    void setKm(View v){
        miTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        kmTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
    }

    @OnClick(R.id.mi_weater)
    void setMi(View v){
        kmTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        miTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
    }

    @OnClick(R.id.cels)
    void setCels(View v){
        celsTextView.setImageResource(R.drawable.celsius);
        farTextView.setImageResource(R.drawable.fahrenheit_unselected);
    }

    @OnClick(R.id.far)
    void setFar(View v){
        celsTextView.setImageResource(R.drawable.celsius_unselected);
        farTextView.setImageResource(R.drawable.fahrenheit);
    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
