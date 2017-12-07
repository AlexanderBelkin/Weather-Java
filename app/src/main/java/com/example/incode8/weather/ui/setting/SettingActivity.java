package com.example.incode8.weather.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incode8.weather.R;
import com.example.incode8.weather.ui.base.BaseActivity;
import com.example.incode8.weather.ui.weather.WeatherActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.incode8.weather.R.id.cels;

public class SettingActivity extends BaseActivity implements ISettingView{

    @BindView(R.id.day_weather)
    TextView dayTextView;

    @BindView(R.id.three_days)
    TextView weekTextView;

    @BindView(R.id.week_weather)
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

    @BindView(R.id.city_user)
    TextView cityUser;

    Typeface typeface;

    @Inject
    ISettingPresenter<ISettingView> mPresenter;

    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getActivityComponents().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(SettingActivity.this);
        onInitComponent();
        UserPref();
    }

    @Override
    public void UserPref() {
        switch (WeatherActivity.pref.get(1)){
            case "day":
                setDay(getWindow().getDecorView().getRootView());
                break;
            case "threeDay":
                setThreeDays(getWindow().getDecorView().getRootView());
                break;
            case "week":
                setWeek(getWindow().getDecorView().getRootView());
                break;
        }
        switch (WeatherActivity.pref.get(0)){
            case "c":
                setCels(getWindow().getDecorView().getRootView());
                break;
            case "f":
                setFar(getWindow().getDecorView().getRootView());
        }
        switch (WeatherActivity.pref.get(2)){
            case "m/s":
                setKm(getWindow().getDecorView().getRootView());
                break;
            case "Mi/hour":
                setMi(getWindow().getDecorView().getRootView());
        }
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        return intent;
    }

    @OnClick(R.id.search_btn)
    void setSearch(View v) {
        initSearch();
    }

    @OnClick(R.id.city_user)
    void SetSearchTextView(View v){
        initSearch();
    }

    @Override
    public void initSearch() {
        try {
            Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                    .build(this);
            startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
        }catch (Exception ex){
            ex.getMessage();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = PlaceAutocomplete.getPlace(this, data);
                cityUser.setText(place.getName().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                // TODO: Handle the error.
                Log.i("", status.getStatusMessage());

            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
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
        mPresenter.setUserFrequency(this, "day");
    }

    @OnClick(R.id.three_days)
    void setThreeDays(View v){
        dayTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        weekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
        twoWeekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        mPresenter.setUserFrequency(this, "threeDay");
    }

    @OnClick(R.id.week_weather)
    void setWeek(View v){
        dayTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        weekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        twoWeekTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
        mPresenter.setUserFrequency( this, "week");
    }

    @OnClick(R.id.km_weater)
    void setKm(View v){
        miTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        kmTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
        mPresenter.setUserSpeed(this, getBaseContext().getString(R.string.km));
    }

    @OnClick(R.id.mi_weater)
    void setMi(View v){
        kmTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
        miTextView.setTextColor(ContextCompat.getColor(v.getContext(), R.color.dayPrimary));
        mPresenter.setUserSpeed(this, getBaseContext().getString(R.string.mi));
    }

    @OnClick(R.id.cels)
    void setCels(View v){
        celsTextView.setImageResource(R.drawable.celsius);
        farTextView.setImageResource(R.drawable.fahrenheit_unselected);
        mPresenter.setUserTemperature(this, "c");
    }

    @OnClick(R.id.far)
    void setFar(View v){
        celsTextView.setImageResource(R.drawable.celsius_unselected);
        farTextView.setImageResource(R.drawable.fahrenheit);
        mPresenter.setUserTemperature(this, "f");
    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
