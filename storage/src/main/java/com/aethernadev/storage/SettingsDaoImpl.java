package com.aethernadev.storage;

import android.support.annotation.NonNull;

import com.aethernadev.storage.location.RealmLocation;
import com.aethernadev.storage.location.RealmLocationMapper;
import com.aethernadev.sunny.dao.SettingsDao;
import com.aethernadev.sunny.data.Location;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Aetherna.
 */
public class SettingsDaoImpl implements SettingsDao {

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
            saveLocation(location);
        }
        return true;
    }

    public void deleteOldUserLocations() {
        RealmResults<RealmLocation> toDelete = realm.where(RealmLocation.class).findAll();
        realm.beginTransaction();
        toDelete.clear();
        realm.commitTransaction();
    }

    private void saveLocation(Location location) {
        realm.beginTransaction();

        RealmLocation realmLocation = realm.createObject(RealmLocation.class);
        mapper.mapToRealm(location, realmLocation);

        realm.commitTransaction();
    }


    @Override
    public List<Location> getUserLocations() {
        RealmResults<RealmLocation> results = realm.where(RealmLocation.class).findAll();
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
