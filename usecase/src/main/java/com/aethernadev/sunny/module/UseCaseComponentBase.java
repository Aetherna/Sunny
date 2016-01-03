package com.aethernadev.sunny.module;

import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.main.forecast.GetForecastUseCase;
import com.aethernadev.sunny.searchlocation.FindLocationsUseCase;
import com.aethernadev.sunny.settings.GetUserSettingsUseCase;
import com.aethernadev.sunny.settings.SaveUserSettingsUseCase;

/**
 * Created by Aetherna on 2015-12-29.
 */
public interface UseCaseComponentBase {

    FindLocationsUseCase findLocationsUseCase();

    SaveUserSettingsUseCase saveUserSettingsUseCase();

    GetUserSettingsUseCase getUserSettingsUseCase();

    UseCaseExecutor useCaseExecutor();

    GetForecastUseCase getForecastUseCase();
}
