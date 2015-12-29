package com.aethernadev.sunny.dagger;

import android.content.SharedPreferences;

import com.aethernadev.sunny.MainActivity;
import com.aethernadev.sunny.main.firstlaunch.FirstInitPresenter;
import com.aethernadev.sunny.module.UseCaseComponentBase;
import com.aethernadev.sunny.settings.SettingsActivity;
import com.aethernadev.sunny.settings.SettingsCitiesPresenter;
import com.aethernadev.sunny.settings.SettingsMainPresenter;
import com.aethernadev.sunny.settings.cities.SettingsCitiesFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aetherna.
 */
@Singleton
@Component(dependencies = {UseCaseComponentBase.class}, modules = PreferencesModule.class)
public interface AppComponent {


    SettingsCitiesPresenter settingsCitiesPresenter();

    SettingsMainPresenter settingsMainPresenter();

    FirstInitPresenter firstInitPresenter();

    SharedPreferences preferences();

    void inject(SettingsActivity settingsActivity);

    void inject(SettingsCitiesFragment settingsCitiesFragment);

    void inject(MainActivity mainActivity);
}
