package com.aethernadev.sunny.testutils;

import com.aethernadev.sunny.base.UseCase;
import com.aethernadev.sunny.base.UseCaseExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by Marta on 03/01/2016.
 */
public class TestSyncUseCaseExecutor implements UseCaseExecutor {

    @Inject
    public TestSyncUseCaseExecutor() {
    }

    @Override
    public <Result, Argument> Observable<Result> wrap(UseCase<Result, Argument> useCase, Argument argument) {

        return useCase.execute(argument)
                .subscribeOn(Schedulers.immediate())
                .observeOn(Schedulers.immediate());
    }
}
