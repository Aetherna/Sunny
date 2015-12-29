package com.aethernadev.sunny.main;

import com.aethernadev.sunny.InitDefaultSettingsUseCase;
import com.aethernadev.sunny.base.UseCaseExecutor;

import javax.inject.Inject;

/**
 * Created by Aetherna on 2015-12-28.
 */
public class MainPresenter {

    InitDefaultSettingsUseCase initDefaultSettingsUseCase;
    private UseCaseExecutor executor;

    @Inject
    public MainPresenter(UseCaseExecutor executor) {
        this.executor = executor;
    }
}
