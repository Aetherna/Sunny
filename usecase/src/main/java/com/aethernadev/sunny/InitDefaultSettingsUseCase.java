package com.aethernadev.sunny;

import com.aethernadev.sunny.base.UseCase;
import com.aethernadev.sunny.dao.SettingsDao;
import com.aethernadev.sunny.data.Location;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Aetherna on 2015-12-29.
 */
public class InitDefaultSettingsUseCase implements UseCase<Boolean, List<Location>> {

    SettingsDao settingsDao;

    @Inject
    public InitDefaultSettingsUseCase(SettingsDao settingsDao) {
        this.settingsDao = settingsDao;
    }

    @Override
    public Observable<Boolean> execute(List<Location> locations) {
        return Observable.just(settingsDao.saveDefaultLocations(locations));
    }
}
