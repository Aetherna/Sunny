package com.aethernadev.sunny.dagger;

import com.aethernadev.sunny.FindLocationsUseCase;
import com.aethernadev.sunny.GetDefaultSettingsUseCase;
import com.aethernadev.sunny.GetUserSettingsUseCase;
import com.aethernadev.sunny.InitDefaultSettingsUseCase;
import com.aethernadev.sunny.SaveUserSettingsUseCase;
import com.aethernadev.sunny.module.UseCaseComponentBase;
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

    GetDefaultSettingsUseCase getDefaultSettingsUseCase();

    GetUserSettingsUseCase getUserSettingsUseCase();

    InitDefaultSettingsUseCase initDefaultSettingsUseCase();

    AsyncUseCaseExecutor useCaseExecutor();
}
