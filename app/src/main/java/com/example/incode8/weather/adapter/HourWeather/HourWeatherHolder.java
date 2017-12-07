package com.example.incode8.weather.adapter.HourWeather;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incode8.weather.R;

/**
 * Created by incode8 on 15.08.17.
 */

public class HourWeatherHolder extends RecyclerView.ViewHolder {

    public ImageView weatherImage;
    public TextView weatherTemp;
    public TextView weatherDiscription;

    public HourWeatherHolder(View itemView) {
        super(itemView);
        weatherImage = (ImageView) itemView.findViewById(R.id.item_image);
        weatherTemp = (TextView) itemView.findViewById(R.id.item_temp);
        weatherDiscription = (TextView) itemView.findViewById(R.id.item_description);
    }


}
