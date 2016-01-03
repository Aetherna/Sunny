package com.aethernadev.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.aethernadev.storage.location.RealmLocationMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Aetherna.
 */

@Singleton
@Module
public class StorageModule {

    private Context context;

    public StorageModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    Realm provideRealm() {
        return Realm.getInstance(context);
    }

    @Singleton
    @Provides
    SettingsDaoImpl provideSettingsDao(RealmLocationMapper mapper, Realm realm) {
        return new SettingsDaoImpl(mapper, realm);
    }

    @Singleton
    @Provides
    RealmLocationMapper provideMapper() {
        return new RealmLocationMapper();
    }

}
