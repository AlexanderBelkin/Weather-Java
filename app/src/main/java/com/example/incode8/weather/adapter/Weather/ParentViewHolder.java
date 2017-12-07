package com.example.incode8.weather.adapter.Weather;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incode8.weather.R;
import com.example.incode8.weather.mapper.ImageMapper;
import com.example.incode8.weather.models.daily_model.Daily;
import com.example.incode8.weather.models.daily_model.WeatherDailyParametr;
import com.example.incode8.weather.ui.hour_weather_fragment.HourWeatherFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zlc.season.practicalrecyclerview.AbstractAdapter;
import zlc.season.practicalrecyclerview.AbstractViewHolder;

/**
 * Created by incode8 on 14.08.17.
 */

public class ParentViewHolder extends AbstractViewHolder<Daily> {

    @BindView(R.id.item_description)
    TextView itemDescriptionTextView;

    @BindView(R.id.item_image)
    ImageView itemImageView;

    @BindView(R.id.item_temp)
    TextView itemTempTextView;

    private Daily parent;
    private List<WeatherDailyParametr> child;
    private Context mContext;
    private DailyWeatherRecyclerAdapter mAdapter;
    private ImageMapper imageMapper;

    ParentViewHolder(AbstractAdapter adapter, ViewGroup parent) {
        super(parent, R.layout.recyclerview_item_row);
        ButterKnife.bind(this, itemView);
        mContext = parent.getContext();
        mAdapter = (DailyWeatherRecyclerAdapter) adapter;
    }

    @Override
    public void setData(Daily data) {
        imageMapper = new ImageMapper(getTime());
        itemDescriptionTextView.setText(String.valueOf(data.dateDaily));
        itemImageView.setImageResource(imageMapper.setImage(data.iconDaily));
        itemTempTextView.setText(data.temperatureDaily + "\u00B0");
        child = data.dailyParametrs;
        parent = data;
    }

    @OnClick(R.id.item_description)
    public void onClick() {
        ((FragmentActivity) mContext).getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(HourWeatherFragment.TAG)
                .replace(R.id.weather_frame, HourWeatherFragment.newInstance(getAdapterPosition()), HourWeatherFragment.TAG)
                .commit();
    }

    public int getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH");
        return Integer.parseInt(mdformat.format(calendar.getTime()));
    }

}
