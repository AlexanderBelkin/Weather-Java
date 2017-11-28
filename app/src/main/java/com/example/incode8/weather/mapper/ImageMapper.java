package com.example.incode8.weather.mapper;

import com.example.incode8.weather.R;

/**
 * Created by incode8 on 10.08.17.
 */

public class ImageMapper {

    private int time;
    public int imageID;

    public ImageMapper(int time){
        this.time = time;
    }

    public int setImage(String clouds) {
        switch (clouds){
            case "01d":
                if(time < 19 && time > 6)
                    imageID = R.drawable.sun;
                else
                    imageID = R.drawable.night;
                break;
            case "02d":
                if(time < 19 && time > 6)
                    imageID = R.drawable.cloudysun;
                else
                    imageID = R.drawable.cloudnight;
                break;
            case "03d":
                imageID = R.drawable.cloudy;
                break;
            case "04d":
                imageID = R.drawable.cloudy;
                break;
            case "09d":
                imageID = R.drawable.rain;
                break;
            case "10d":
                imageID = R.drawable.rain;
                break;
            case "11d":
                imageID = R.drawable.thunder;
                break;
            case "13d":
                imageID = R.drawable.snow;
                break;
            case "50d":
                imageID = R.drawable.fog;
                break;
        }
        return imageID;
    }
}
