package com.aethernadev.sunny.module;

import com.aethernadev.sunny.base.UseCaseExecutor;
import com.aethernadev.sunny.usecaseexecutor.AsyncUseCaseExecutor;

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


