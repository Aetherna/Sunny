package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.DataComponent;
import com.aethernadev.sunny.MainActivity;

import javax.inject.Singleton;

import aethernadev.com.weatherprovider.WeatherDaoImpl;
import aethernadev.com.weatherprovider.module.RetrofitModule;
import dagger.Component;

/**
 * Created by Aetherna.
 */
@Singleton
@Component(modules = {RetrofitModule.class})
public interface WeatherComponent extends DataComponent {

    WeatherDaoImpl weather();

}
