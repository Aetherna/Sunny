package com.aethernadev.sunny.module;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.settings.SettingsCitiesPresenter;
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
    SettingsCitiesPresenter provideSettingsPresenter(FindLocationsUseCase findLocationsUseCase, AsyncUseCaseExecutor useCaseExecutor) {
        return new SettingsCitiesPresenter(findLocationsUseCase, useCaseExecutor);
    }
}
