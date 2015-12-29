package com.aethernadev.sunny.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aetherna on 2015-12-30.
 */
@Module
public class PreferencesModule {

    public static final String SUNNY_APP_PREFERENCE_FILE = "SUNNY_APP_PREFERENCE_FILE";
    private Context context;

    public PreferencesModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    SharedPreferences preferences() {
        return context.getSharedPreferences(SUNNY_APP_PREFERENCE_FILE, Context.MODE_PRIVATE);
    }
}
