package com.aethernadev.sunny;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.aethernadev.sunny.dagger.AppComponent;
import com.aethernadev.sunny.dagger.DaggerAppComponent;
import com.aethernadev.sunny.dagger.DaggerWeatherComponent;
import com.aethernadev.sunny.dagger.WeatherComponent;
import com.aethernadev.sunny.main.MainPresenter;
import com.aethernadev.sunny.settings.SettingsPresenter;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

import javax.inject.Inject;


public class MainActivity extends ActionBarActivity implements SettingsPresenter.SettingsUI {

    @Inject
    SettingsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherComponent dataComponent = DaggerWeatherComponent.builder().build();

        AppComponent appComponent = DaggerAppComponent.builder().dataComponent(dataComponent).build();

        appComponent.inject(this);


        presenter.attachUI(this);
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onLocationSearch("London");

            }
        });

    }

    @Override
    public void addLocation(Location location) {
        Toast.makeText(this, location.getName() + location.getCountry() + location.getRegion() + location.getLongitude() + "" + location.getLatitude(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String error) {

    }
}
