package com.example.incode8.weather.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.incode8.weather.R;
import com.example.incode8.weather.ui.base.BaseActivity;

public class SettingActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        return intent;
    }
}
