package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.DataComponent;
import com.aethernadev.sunny.MainActivity;
import com.aethernadev.sunny.main.MainPresenter;
import com.aethernadev.sunny.module.PresenterModule;
import com.aethernadev.sunny.module.UseCaseModule;
import com.aethernadev.sunny.settings.SettingsPresenter;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aetherna.
 */
@Singleton
@Component(dependencies = {DataComponent.class})
public interface AppComponent {


    SettingsPresenter settingsPresenter();

    void inject(MainActivity mainActivity);
}
