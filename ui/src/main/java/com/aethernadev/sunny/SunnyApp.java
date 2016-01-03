package com.aethernadev.sunny;

import android.app.Application;

import com.aethernadev.storage.StorageModule;
import com.aethernadev.sunny.dagger.AppComponent;
import com.aethernadev.sunny.dagger.DaggerAppComponent;
import com.aethernadev.sunny.dagger.DaggerDaoComponent;
import com.aethernadev.sunny.dagger.DaggerUseCaseComponent;
import com.aethernadev.sunny.dagger.DaoComponent;
import com.aethernadev.sunny.dagger.AndroidModule;
import com.aethernadev.sunny.dagger.UseCaseComponent;

/**
 * Created by Aetherna.
 */
public class SunnyApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoComponent daoComponent = DaggerDaoComponent.builder()
                .storageModule(new StorageModule(this))
                .build();
        UseCaseComponent useCaseComponent = DaggerUseCaseComponent
                .builder()
                .daoComponentBase(daoComponent)
                .build();
        appComponent = DaggerAppComponent.builder()
                .useCaseComponentBase(useCaseComponent)
                .androidModule(new AndroidModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
