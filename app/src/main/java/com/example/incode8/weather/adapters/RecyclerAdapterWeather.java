package com.example.incode8.weather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.incode8.weather.R;
import com.example.incode8.weather.mapper.ImageMapper;
import com.example.incode8.weather.models.forecast_model.Forecast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by incode8 on 11.08.17.
 */

public class RecyclerAdapterWeather extends RecyclerView.Adapter<WeatherHolder> {

    private ArrayList<Forecast> weather = new ArrayList<>();
    private Context context;
    private ImageMapper imageMapper;


    public RecyclerAdapterWeather(ArrayList<Forecast> weather, Context context){
        this.weather = weather;
        this.context = context;
        imageMapper = new ImageMapper(getTime());
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_row, parent, false);
        return new WeatherHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        Forecast forecast = weather.get(position);
        holder.weatherTemp.setText(forecast.temperatureForecast);
        holder.weatherDiscription.setText(forecast.dateForecast.replaceAll("15:00:00", ""));
        holder.weatherImage.setImageResource(imageMapper.setImage(forecast.iconForecast));
    }

    @Override
    public int getItemCount() {
        return weather.size();
    }

    public int getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH");
        return Integer.parseInt(mdformat.format(calendar.getTime()));
    }
}
