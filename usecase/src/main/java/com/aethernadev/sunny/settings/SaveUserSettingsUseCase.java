package com.aethernadev.sunny.settings;

import com.aethernadev.sunny.base.UseCase;
import com.aethernadev.sunny.dao.SettingsDao;
import com.aethernadev.sunny.data.Location;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Aetherna.
 */
public class SaveUserSettingsUseCase implements UseCase<Boolean, List<com.aethernadev.sunny.data.Location>> {

    SettingsDao settingsDao;

    @Inject
    public SaveUserSettingsUseCase(SettingsDao settingsDao) {
        this.settingsDao = settingsDao;
    }

    @Override
    public Observable<Boolean> execute(List<Location> locations) {
        return Observable.just(settingsDao.saveUserLocations(locations));
    }
}
