package com.aethernadev.sunny.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.aethernadev.sunny.main.WeatherFormat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-12-30.
 */
@Module
public class AndroidModule {

    public static final String SUNNY_APP_PREFERENCE_FILE = "SUNNY_APP_PREFERENCE_FILE";
    private Context context;

    public AndroidModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    SharedPreferences preferences() {
        return context.getSharedPreferences(SUNNY_APP_PREFERENCE_FILE, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    WeatherFormat weatherFormat() {
        return new WeatherFormat(context);
    }
}
