package com.aethernadev.sunny.presenter.module;

import com.aethernadev.sunny.presenter.usecaseexecutor.AsyncUseCaseExecutor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-12-28.
 */
@Module
public class ExecutorModule {

    @Provides
    AsyncUseCaseExecutor executor() {
        return new AsyncUseCaseExecutor();
    }
}


