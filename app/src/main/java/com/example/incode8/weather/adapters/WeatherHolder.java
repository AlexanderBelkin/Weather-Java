package com.example.incode8.weather.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.incode8.weather.R;

/**
 * Created by incode8 on 11.08.17.
 */

public class WeatherHolder extends RecyclerView.ViewHolder{

public ImageView weatherImage;
public TextView weatherTemp;
public TextView weatherDiscription;
public LinearLayout linearWeather;


    public WeatherHolder(View itemView) {
        super(itemView);
        weatherImage = (ImageView) itemView.findViewById(R.id.item_image);
        weatherTemp = (TextView) itemView.findViewById(R.id.item_temp);
        weatherDiscription = (TextView) itemView.findViewById(R.id.item_description);
        linearWeather = (LinearLayout) itemView.findViewById(R.id.linearWeather);
    }

}