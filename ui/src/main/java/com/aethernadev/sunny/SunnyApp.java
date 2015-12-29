package com.aethernadev.sunny;

import android.app.Application;

import com.aethernadev.sunny.dagger.AppComponent;
import com.aethernadev.sunny.dagger.DaggerAppComponent;
import com.aethernadev.sunny.dagger.DaggerWeatherComponent;
import com.aethernadev.sunny.dagger.WeatherComponent;

/**
 * Created by Aetherna on 2015-12-28.
 */
public class SunnyApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        WeatherComponent dataComponent = DaggerWeatherComponent.builder().build();
        appComponent = DaggerAppComponent.builder().dataComponent(dataComponent).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
