package com.aethernadev.sunny.dagger;

import android.content.SharedPreferences;

import com.aethernadev.sunny.MainActivity;
import com.aethernadev.sunny.main.ForecastFragment;
import com.aethernadev.sunny.presenter.main.MainPresenter;
import com.aethernadev.sunny.main.WeatherFormat;
import com.aethernadev.sunny.presenter.main.firstlaunch.FirstInitPresenter;
import com.aethernadev.sunny.presenter.main.forecast.ForecastPresenter;
import com.aethernadev.sunny.module.UseCaseComponentBase;
import com.aethernadev.sunny.settings.SettingsActivity;
import com.aethernadev.sunny.presenter.settings.SettingsCitiesPresenter;
import com.aethernadev.sunny.presenter.settings.SettingsMainPresenter;
import com.aethernadev.sunny.settings.cities.SettingsCitiesFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aetherna.
 */
@Singleton
@Component(dependencies = {UseCaseComponentBase.class}, modules = AndroidModule.class)
public interface AppComponent {


    SettingsCitiesPresenter settingsCitiesPresenter();

    SettingsMainPresenter settingsMainPresenter();

    FirstInitPresenter firstInitPresenter();

    ForecastPresenter forecastPresenter();

    MainPresenter mainPresenter();

    SharedPreferences preferences();

    WeatherFormat weatherFormat();

    void inject(SettingsActivity settingsActivity);

    void inject(SettingsCitiesFragment settingsCitiesFragment);

    void inject(MainActivity mainActivity);

    void inject(ForecastFragment forecastFragment);
}
