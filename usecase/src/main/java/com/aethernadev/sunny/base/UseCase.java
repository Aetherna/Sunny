package com.aethernadev.sunny.base;

import rx.Observable;

/**
 * Created by Aetherna.
 */
public interface UseCase<Result, Argument> {

    Observable<Result> execute(Argument arg);
}
