package com.example.incode8.weather.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.incode8.weather.R;
import com.example.incode8.weather.mapper.ImageMapper;
import com.example.incode8.weather.models.daily_model.Daily;
import com.example.incode8.weather.models.daily_model.WeatherDailyParametr;

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
        itemTempTextView.setText(data.temperatureDaily);
        child = data.dailyParametrs;
        parent = data;
    }

    @OnClick(R.id.item_description)
    public void onClick() {
        if (parent.isExpand) {
            mAdapter.removeBack(getAdapterPosition(), child.size());
            parent.isExpand = false;
        } else {
            mAdapter.insertAllBack(getAdapterPosition(), child);
            parent.isExpand = true;
        }
    }

    public int getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH");
        return Integer.parseInt(mdformat.format(calendar.getTime()));
    }

}
