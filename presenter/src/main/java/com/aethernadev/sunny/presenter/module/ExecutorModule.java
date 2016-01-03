package com.aethernadev.sunny.presenter.module;

import com.aethernadev.sunny.presenter.usecaseexecutor.AsyncUseCaseExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna.
 */
@Module
public class ExecutorModule {

    @Provides
    AsyncUseCaseExecutor executor() {
        return new AsyncUseCaseExecutor();
    }
}


