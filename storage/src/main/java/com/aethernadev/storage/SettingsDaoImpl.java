package com.aethernadev.storage;

import android.support.annotation.NonNull;

import com.aethernadev.storage.location.RealmLocation;
import com.aethernadev.storage.location.RealmLocationMapper;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.dao.SettingsDao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.aethernadev.storage.location.SettingType.*;

/**
 * Created by Aetherna on 2015-12-29.
 */
public class SettingsDaoImpl implements SettingsDao {

    public static final String SETTING_TYPE_COLUMN = "settingType";
    RealmLocationMapper mapper;
    Realm realm;

    @Inject
    public SettingsDaoImpl(RealmLocationMapper mapper, Realm realm) {
        this.mapper = mapper;
        this.realm = realm;
    }

    @Override
    public boolean saveUserLocations(List<Location> locations) {

        deleteOldUserLocations();

        for (Location location : locations) {
            saveLocation(location, USER.getType());
        }
        return true;
    }

    private void deleteOldUserLocations() {
        RealmResults<RealmLocation> toDelete = realm.where(RealmLocation.class).equalTo(SETTING_TYPE_COLUMN, USER.getType()).findAll();
        realm.beginTransaction();
        toDelete.clear();
        realm.commitTransaction();
    }

    private void saveLocation(Location location, int settingType) {
        realm.beginTransaction();

        RealmLocation realmLocation = realm.createObject(RealmLocation.class);
        mapper.mapToRealm(location, realmLocation);
        realmLocation.setSettingType(settingType);

        realm.commitTransaction();
    }

    @Override
    public boolean saveDefaultLocations(List<Location> locations) {
        for (Location location : locations) {
            saveLocation(location, DEFAULT.getType());
        }
        return true;
    }

    @Override
    public List<Location> getUserLocations() {
        RealmResults<RealmLocation> results = realm.where(RealmLocation.class).equalTo(SETTING_TYPE_COLUMN, USER.getType()).findAll();
        return mapResultsToLocations(results);
    }

    @Override
    public List<Location> getDefaultLocations() {
        RealmResults<RealmLocation> results = realm.where(RealmLocation.class).equalTo(SETTING_TYPE_COLUMN, DEFAULT.getType()).findAll();
        return mapResultsToLocations(results);
    }

    @NonNull
    private List<Location> mapResultsToLocations(RealmResults<RealmLocation> results) {
        List<Location> locations = new ArrayList<>(results.size());
        for (RealmLocation realmLocation : results) {
            locations.add(mapper.mapToLocation(realmLocation));
        }
        return locations;
    }
}
