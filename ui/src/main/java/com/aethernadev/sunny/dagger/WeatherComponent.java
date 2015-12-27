package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.MainActivity;

import javax.inject.Singleton;

import aethernadev.com.weatherprovider.WeatherDaoImpl;
import aethernadev.com.weatherprovider.module.RetrofitModule;
import dagger.Component;

/**
 * Created by Aetherna on 2015-12-26.
 */
@Singleton
@Component(dependencies = RetrofitModule.class)
public interface WeatherComponent {

    WeatherDaoImpl weather();

    void inject(MainActivity mainActivity);

}
