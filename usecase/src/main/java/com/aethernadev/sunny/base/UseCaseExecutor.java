package com.aethernadev.sunny.base;


import rx.Observable;

/**
 * Created by Aetherna.
 */
public interface UseCaseExecutor {

    <Result, Argument> Observable<Result> wrap(UseCase<Result, Argument> useCase, Argument argument);

}
