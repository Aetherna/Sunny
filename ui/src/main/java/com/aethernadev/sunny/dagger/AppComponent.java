package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.DataComponent;
import com.aethernadev.sunny.MainActivity;
import com.aethernadev.sunny.settings.SettingsCitiesPresenter;
import com.aethernadev.sunny.settings.cities.SettingsCitiesFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aetherna.
 */
@Singleton
@Component(dependencies = {DataComponent.class})
public interface AppComponent {


    SettingsCitiesPresenter settingsPresenter();

    void inject(MainActivity mainActivity);

    void inject(SettingsCitiesFragment settingsCitiesFragment);
}
