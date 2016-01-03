package com.aethernadev.sunny.presenter.error;

import android.content.Context;

/**
 * Created by Marta on 03/01/2016.
 */
public class UnknownError implements PrintableError {

    private Throwable error;

    public UnknownError(final Throwable error) {
        this.error = error;
    }

    @Override
    public String getMessage(final Context context) {
        return error.getMessage();
    }
}
