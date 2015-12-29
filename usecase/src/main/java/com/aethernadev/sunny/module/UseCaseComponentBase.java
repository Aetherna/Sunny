package com.aethernadev.sunny.module;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.GetDefaultSettingsUseCase;
import com.aethernadev.sunny.GetUserSettingsUseCase;
import com.aethernadev.sunny.InitDefaultSettingsUseCase;
import com.aethernadev.sunny.SaveUserSettingsUseCase;
import com.aethernadev.sunny.base.UseCaseExecutor;

/**
 * Created by Aetherna on 2015-12-29.
 */
public interface UseCaseComponentBase {

    FindLocationsUseCase findLocationsUseCase();

    SaveUserSettingsUseCase saveUserSettingsUseCase();

    GetUserSettingsUseCase getUserSettingsUseCase();

    GetDefaultSettingsUseCase getDefaultSettingsUseCase();

    InitDefaultSettingsUseCase initDefaultSettingsUseCase();

    UseCaseExecutor useCaseExecutor();
}
