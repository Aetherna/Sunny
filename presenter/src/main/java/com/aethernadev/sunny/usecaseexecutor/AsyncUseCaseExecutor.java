package com.aethernadev.sunny.usecaseexecutor;

import com.aethernadev.sunny.base.UseCase;
import com.aethernadev.sunny.base.UseCaseExecutor;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Aetherna.
 */

public class AsyncUseCaseExecutor implements UseCaseExecutor {

    @Inject
    public AsyncUseCaseExecutor() {
    }

    @Override
    public <Result, Argument> Observable<Result> wrap(UseCase<Result, Argument> useCase, Argument argument) {

        return useCase.execute(argument)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
