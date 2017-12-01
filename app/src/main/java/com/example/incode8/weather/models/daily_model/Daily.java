package com.example.incode8.weather.models.daily_model;

import com.example.incode8.weather.adapter.RecyclerItemType;

import java.util.ArrayList;

import zlc.season.practicalrecyclerview.ItemType;

/**
 * Created by incode8 on 13.08.17.
 */

public class Daily implements ItemType {

    public String cloudsDaily;

    public String temperatureDaily;

    public String iconDaily;

    public String dateDaily;

    public ArrayList<WeatherDailyParametr> dailyParametrs;

    public boolean isExpand;

    @Override
    public int itemType() {
        return RecyclerItemType.PARENT.getValue();
    }
}
