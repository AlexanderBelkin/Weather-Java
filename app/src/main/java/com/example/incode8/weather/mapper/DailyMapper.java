package com.example.incode8.weather.mapper;

import com.example.incode8.weather.models.daily_model.Daily;
import com.example.incode8.weather.models.daily_model.DailyModel;
import com.example.incode8.weather.models.daily_model.DailyModelUi;
import com.example.incode8.weather.models.daily_model.List;
import com.example.incode8.weather.models.daily_model.Temp;
import com.example.incode8.weather.models.daily_model.Weather;
import com.example.incode8.weather.models.daily_model.WeatherDailyParametr;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by incode8 on 13.08.17.
 */

public class DailyMapper {

    private static DailyModelUi dailyModelUi = new DailyModelUi();
    private static Daily daily;

    public static DailyModelUi map(DailyModel dailyData) {
        dailyModelUi.listDaily = new ArrayList<>();
        java.util.List<List> dailyList = dailyData.getList();
        for(List dailyItem : dailyList){
            daily = new Daily();
            Weather daileWeather = dailyItem.getWeather().get(0);
            daily.cloudsDaily = daileWeather.getMain();
            daily.iconDaily = daileWeather.getIcon();
            Temp tempDaily = dailyItem.getTemp();
            daily.temperatureDaily = String.valueOf(tempDaily.getDay().intValue());
            long dv = Long.valueOf(String.valueOf(dailyItem.getDt().intValue()))*1000;// its need to be in milisecond
            Date df = new java.util.Date(dv);
            daily.dateDaily = new SimpleDateFormat("EEE, MMM d").format(df);
            daily.dailyParametrs = new ArrayList<>();
            WeatherDailyParametr weatherDailyParametr = new WeatherDailyParametr();
            weatherDailyParametr.pressureDaily = String.valueOf(dailyItem.getPressure().intValue());
            weatherDailyParametr.humidityDaily = String.valueOf(dailyItem.getHumidity().intValue());
            weatherDailyParametr.windDaily = String.valueOf(dailyItem.getSpeed());
            weatherDailyParametr.cloudinessDaily = String.valueOf(dailyItem.getClouds().intValue());
            daily.dailyParametrs.add(weatherDailyParametr);
            dailyModelUi.listDaily.add(daily);
        }
        return dailyModelUi;
    }

}
