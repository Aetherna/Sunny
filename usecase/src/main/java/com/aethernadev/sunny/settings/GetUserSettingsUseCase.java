package com.aethernadev.sunny.settings;

import com.aethernadev.sunny.base.UseCase;
import com.aethernadev.sunny.dao.SettingsDao;
import com.aethernadev.sunny.data.Location;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Aetherna on 2015-12-29.
 */
public class GetUserSettingsUseCase implements UseCase<List<Location>, Void> {

    SettingsDao settingsDao;

    @Inject
    public GetUserSettingsUseCase(SettingsDao settingsDao) {
        this.settingsDao = settingsDao;
    }


    @Override
    public Observable<List<Location>> execute(Void arg) {
        return Observable.just(settingsDao.getUserLocations());
    }
}
