package com.aethernadev.sunny.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aethernadev.sunny.R;
import com.aethernadev.sunny.SunnyApp;
import com.aethernadev.sunny.data.CurrentConditions;
import com.aethernadev.sunny.data.DayWeather;
import com.aethernadev.sunny.data.Forecast;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.main.dailyforecast.DailyForecastAdapter;
import com.aethernadev.sunny.presenter.error.PrintableError;
import com.aethernadev.sunny.presenter.main.forecast.ForecastPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Aetherna.
 */
public class ForecastFragment extends Fragment implements ForecastPresenter.UI {

    private static final int TODAY = 0;
    private static final String LOCATION = "location";

    @Inject
    protected ForecastPresenter presenter;
    @Inject
    protected WeatherFormat weatherFormat;

    @Bind(R.id.location_name)
    protected TextView locationName;
    @Bind(R.id.location_region)
    protected TextView locationRegion;

    @Bind(R.id.loading_forecast)
    protected ProgressBar progressBar;
    @Bind(R.id.current_temp)
    protected TextView currentTemperature;
    @Bind(R.id.pressure)
    protected TextView pressure;
    @Bind(R.id.weather_description)
    protected TextView weatherDescription;
    @Bind(R.id.dailyForecast)
    protected ListView listView;


    private Location location;
    private View rootView;

    public static ForecastFragment newInstance(Location location) {

        ForecastFragment fragment = new ForecastFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(LOCATION, location);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_forecast, container, false);
        ButterKnife.bind(this, rootView);
        ((SunnyApp) getActivity().getApplication()).getAppComponent().inject(this);

        location = (Location) getArguments().getSerializable(LOCATION);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadForecast(location);
        presenter.attachUI(this);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void showForecast(Forecast forecast) {
        progressBar.setVisibility(View.GONE);
        initTodayView(forecast.getCurrentConditions());
        initDailyForecast(forecast.getDailyForecast());
    }


    private void initTodayView(CurrentConditions currentConditions) {

        locationName.setText(location.getName());
        if (!location.getRegion().isEmpty()) {
            locationRegion.setText(location.getRegion());
        } else {
            locationRegion.setText(location.getCountry());
        }

        int tempNow = currentConditions.getTemperatureNowCelsius();
        currentTemperature.setText(weatherFormat.formatToCelsius(tempNow));
        if (tempNow < 0) {
            currentTemperature.setTextColor(getContext().getResources().getColor(R.color.colorNight));
        }

        pressure.setText(weatherFormat.formatToPascal(currentConditions.getPressure()));
        weatherDescription.setText(currentConditions.getWeatherDescription());
    }


    private void initDailyForecast(List<DayWeather> dailyForecast) {
        dailyForecast.remove(TODAY);
        DailyForecastAdapter adapter = new DailyForecastAdapter(getContext(), dailyForecast);
        listView.setAdapter(adapter);
    }

    @Override
    public void showError(PrintableError error) {
        Snackbar.make(rootView, error.getMessage(getContext()), Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

}
