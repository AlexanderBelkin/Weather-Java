package com.example.incode8.weather.ui.splash;

import com.example.incode8.weather.data.IDataManager;
import com.example.incode8.weather.models.daily_model.DailyModelUi;
import com.example.incode8.weather.models.forecast_model.ForecastUi;
import com.example.incode8.weather.models.weather_model.WeatherUi;
import com.example.incode8.weather.ui.base.BasePresenter;
import com.example.incode8.weather.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.example.incode8.weather.mapper.WeatherMapper.weatherUi;

/**
 * Created by incode8 on 10.08.17.
 */

public class SplashPresenter <V extends ISplashView> extends BasePresenter<V>
        implements ISplashPresenter<V> {

    @Inject
    public SplashPresenter(ISchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable,
                           IDataManager dataManager) {
        super(schedulerProvider, compositeDisposable, dataManager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
        getWeatherNow();
        getWeatherForecast();
    }

    @Override
    public void getWeatherNow() {
        getDataManager().getDataWeatherNow()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeatherUi>() {
                    @Override
                    public void accept(@NonNull WeatherUi weatherData) throws Exception {
                        weatherUi = weatherData;
                        getMvpView().successWeather(weatherUi);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void getWeatherForecast() {
        getDataManager().getDataWeatherForecast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ForecastUi>() {
                    @Override
                    public void accept(@NonNull ForecastUi forecastUi) throws Exception {
                        getMvpView().successForecast(forecastUi);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        String temp = "";
                    }
                });
    }

    @Override
    public void getWeatherForecastDaily() {
        getDataManager().getDataWeatherDaily()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DailyModelUi>() {
                    @Override
                    public void accept(@NonNull DailyModelUi dailyModelUi) throws Exception {
                        getMvpView().successDaily(dailyModelUi);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        String test = "test";
                    }
                });
    }

}
