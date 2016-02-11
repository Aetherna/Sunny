package com.aethernadev.sunny.presenter.error;

import android.content.Context;

import com.aethernadev.sunny.presenter.R;

/**
 * Created by IT on 2016-02-11.
 */
public class LocationAlreadyAdded implements PrintableError {
    @Override
    public String getMessage(Context context) {
        return context.getString(R.string.location_already_added);
    }
}
