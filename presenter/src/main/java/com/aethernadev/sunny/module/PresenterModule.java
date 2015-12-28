package com.aethernadev.sunny.module;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.settings.SettingsPresenter;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-12-27.
 */
@Module(includes = ExecutorModule.class)
public class PresenterModule {

    @Provides
    SettingsPresenter provideSettingsPresenter(FindLocationsUseCase findLocationsUseCase, AsyncUseCaseExecutor useCaseExecutor) {
        return new SettingsPresenter(findLocationsUseCase, useCaseExecutor);
    }
}
