package com.aethernadev.sunny.presenter.error;

import android.content.Context;

import com.aethernadev.sunny.presenter.R;

/**
 * Created by Marta on 03/01/2016.
 */
public enum SunnyError implements PrintableError {
    CONNECTION_ERROR(R.string.connection_error),
    NO_RESULTS(R.string.no_results_found);

    private int messageResource;

    SunnyError(final int messageResource) {
        this.messageResource = messageResource;
    }

    @Override
    public String getMessage(Context context) {
        return context.getString(messageResource);
    }
}
