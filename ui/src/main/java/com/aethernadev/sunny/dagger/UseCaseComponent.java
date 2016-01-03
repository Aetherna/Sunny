package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.main.forecast.GetForecastUseCase;
import com.aethernadev.sunny.module.UseCaseComponentBase;
import com.aethernadev.sunny.searchlocation.FindLocationsUseCase;
import com.aethernadev.sunny.settings.GetUserSettingsUseCase;
import com.aethernadev.sunny.settings.SaveUserSettingsUseCase;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Aetherna on 2015-12-29.
 */

@Singleton
@Component(dependencies = DaoComponentBase.class
)
public interface UseCaseComponent extends UseCaseComponentBase {

    FindLocationsUseCase findLocationsUseCase();

    SaveUserSettingsUseCase saveUserSettingsUseCase();

    GetUserSettingsUseCase getUserSettingsUseCase();

    AsyncUseCaseExecutor useCaseExecutor();

    GetForecastUseCase getForecastUseCase();
}
