package com.aethernadev.sunny.module;

import android.content.SharedPreferences;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.GetDefaultSettingsUseCase;
import com.aethernadev.sunny.GetUserSettingsUseCase;
import com.aethernadev.sunny.InitDefaultSettingsUseCase;
import com.aethernadev.sunny.SaveUserSettingsUseCase;
import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.main.firstlaunch.DefaultSettings;
import com.aethernadev.sunny.main.firstlaunch.FirstInitPresenter;
import com.aethernadev.sunny.settings.SettingsCitiesPresenter;
import com.aethernadev.sunny.settings.SettingsMainPresenter;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna.
 */
@Module(includes = ExecutorModule.class)
public class PresenterModule {

    @Singleton
    @Provides
    DefaultSettings provideDefaultSettings() {
        return new DefaultSettings();
    }

    @Singleton
    @Provides
    SettingsCitiesPresenter provideSettingsPresenter(FindLocationsUseCase findLocationsUseCase, GetUserSettingsUseCase getUserSettingsUseCase, GetDefaultSettingsUseCase getDefaultSettingsUseCase, AsyncUseCaseExecutor useCaseExecutor) {
        return new SettingsCitiesPresenter(findLocationsUseCase, getDefaultSettingsUseCase, getUserSettingsUseCase, useCaseExecutor);
    }

    @Singleton
    @Provides
    SettingsMainPresenter provideMainSettingsPresenter(SaveUserSettingsUseCase saveUserSettingsUseCase, AsyncUseCaseExecutor useCaseExecutor) {
        return new SettingsMainPresenter(saveUserSettingsUseCase, useCaseExecutor);
    }

    @Singleton
    @Provides
    FirstInitPresenter provideFirstInitPresenter(InitDefaultSettingsUseCase initDefaultSettingsUseCase, UseCaseExecutor useCaseExecutor, SharedPreferences preferences, DefaultSettings defaultSettings) {
        return new FirstInitPresenter(initDefaultSettingsUseCase, useCaseExecutor, preferences, defaultSettings);
    }
}
