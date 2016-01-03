package com.aethernadev.sunny.settings;

import com.aethernadev.sunny.base.UseCase;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Aetherna on 2015-12-29.
 */
public class SaveUserSettingsUseCase implements UseCase<Boolean, List<com.aethernadev.sunny.data.Location>> {

    com.aethernadev.sunny.dao.SettingsDao settingsDao;

    @Inject
    public SaveUserSettingsUseCase(com.aethernadev.sunny.dao.SettingsDao settingsDao) {
        this.settingsDao = settingsDao;
    }

    @Override
    public Observable<Boolean> execute(List<com.aethernadev.sunny.data.Location> locations) {
        return Observable.just(settingsDao.saveUserLocations(locations));
    }
}
