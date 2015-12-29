package com.aethernadev.sunny.dagger;

import android.content.SharedPreferences;

import com.aethernadev.storage.StorageModule;
import com.aethernadev.storage.SettingsDaoImpl;

import javax.inject.Singleton;

import aethernadev.com.weatherprovider.WeatherDaoImpl;
import aethernadev.com.weatherprovider.module.RetrofitModule;
import dagger.Component;

/**
 * Created by Aetherna.
 */
@Singleton
@Component(modules = {RetrofitModule.class, StorageModule.class})
public interface DaoComponent extends DaoComponentBase {

    WeatherDaoImpl weatherDao();

    SettingsDaoImpl settingsDao();
}
