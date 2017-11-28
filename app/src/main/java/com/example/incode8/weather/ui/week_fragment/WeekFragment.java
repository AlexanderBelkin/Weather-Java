package com.example.incode8.weather.ui.week_fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.incode8.weather.R;
import com.example.incode8.weather.adapters.RecyclerAdapterWeather;
import com.example.incode8.weather.di.component.ActivityComponent;
import com.example.incode8.weather.models.forecast_model.ForecastUI;
import com.example.incode8.weather.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;


public class WeekFragment extends BaseFragment implements IWeekView {

    public static final String TAG = "WeelFragment";
    private RecyclerAdapterWeather recyclerAdapterWeater;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private Typeface typeface;

    @Inject
    IWeekPresenter<IWeekView> mPresenter;

    public static WeekFragment newInstance() {
        Bundle args = new Bundle();
        WeekFragment fragment = new WeekFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_week, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        String fontPath = "fonts/CenturyGothicRegular.ttf";
        typeface = Typeface.createFromAsset(getActivity().getAssets(), fontPath);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapterWeater = new RecyclerAdapterWeather(ForecastUI.listForecast, view.getContext());
        recyclerView.setAdapter(recyclerAdapterWeater);
        return view;
    }

    @Override
    public void onError(String errorString) {

    }

    @Override
    public void onError(@StringRes int idRes) {

    }

    @Override
    public boolean networkConnected() {
        return false;
    }

    @Override
    protected void setUp(View view) {

    }
}
