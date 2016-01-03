package com.aethernadev.sunny.presenter.module;

import android.content.SharedPreferences;

import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.presenter.main.MainPresenter;
import com.aethernadev.sunny.presenter.main.firstlaunch.DefaultSettings;
import com.aethernadev.sunny.presenter.main.firstlaunch.FirstInitPresenter;
import com.aethernadev.sunny.presenter.main.forecast.ForecastPresenter;
import com.aethernadev.sunny.main.forecast.GetForecastUseCase;
import com.aethernadev.sunny.searchlocation.FindLocationsUseCase;
import com.aethernadev.sunny.settings.GetUserSettingsUseCase;
import com.aethernadev.sunny.settings.SaveUserSettingsUseCase;
import com.aethernadev.sunny.presenter.settings.SettingsCitiesPresenter;
import com.aethernadev.sunny.presenter.settings.SettingsMainPresenter;

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
    SettingsCitiesPresenter provideSettingsPresenter(FindLocationsUseCase findLocationsUseCase, GetUserSettingsUseCase getUserSettingsUseCase, UseCaseExecutor useCaseExecutor) {
        return new SettingsCitiesPresenter(findLocationsUseCase, getUserSettingsUseCase, useCaseExecutor);
    }

    @Singleton
    @Provides
    SettingsMainPresenter provideMainSettingsPresenter(SaveUserSettingsUseCase saveUserSettingsUseCase, UseCaseExecutor useCaseExecutor) {
        return new SettingsMainPresenter(saveUserSettingsUseCase, useCaseExecutor);
    }

    @Singleton
    @Provides
    FirstInitPresenter provideFirstInitPresenter(SaveUserSettingsUseCase saveUserSettingsUseCase, UseCaseExecutor useCaseExecutor, SharedPreferences preferences, DefaultSettings defaultSettings) {
        return new FirstInitPresenter(saveUserSettingsUseCase, useCaseExecutor, preferences, defaultSettings);
    }

    @Singleton
    @Provides
    ForecastPresenter provideForecastPresenter(GetForecastUseCase getForecastUseCase, UseCaseExecutor useCaseExecutor) {
        return new ForecastPresenter(getForecastUseCase, useCaseExecutor);
    }

    @Provides
    MainPresenter provideMainPresenter(GetUserSettingsUseCase getUserSettingsUseCase, UseCaseExecutor useCaseExecutor) {
        return new MainPresenter(getUserSettingsUseCase, useCaseExecutor);
    }
}
