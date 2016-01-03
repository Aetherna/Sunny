package com.aethernadev.sunny.presenter.main.firstlaunch;

import com.aethernadev.sunny.data.Location;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Aetherna.
 */
public class DefaultSettings {

    @Inject
    public DefaultSettings() {
    }

    public List<Location> getLocations() {
        List<Location> defaults = new ArrayList<>(4);

        defaults.add(getDublin());
        defaults.add(getLondon());
        defaults.add(getNewYork());
        defaults.add(getBarcelona());

        return defaults;
    }

    private Location getLondon() {
        Location london = new Location();
        london.setName("London");
        london.setRegion("City of London, Greater London");
        london.setCountry("United Kingdom");
        london.setLongitude(-0.106);
        london.setLatitude(51.517);
        return london;
    }

    private Location getNewYork() {
        Location newYork = new Location();
        newYork.setName("NewYork");
        newYork.setRegion("New York");
        newYork.setCountry("United States of America");
        newYork.setLongitude(-74.006);
        newYork.setLatitude(40.714);
        return newYork;
    }

    private Location getDublin() {
        Location dublin = new Location();
        dublin.setName("Dublin");
        dublin.setRegion("Dublin");
        dublin.setCountry("Ireland");
        dublin.setLongitude(-6.249);
        dublin.setLatitude(53.333);
        return dublin;
    }

    private Location getBarcelona() {
        Location barcelona = new Location();
        barcelona.setName("Barcelona");
        barcelona.setRegion("Catalonia");
        barcelona.setCountry("Spain");
        barcelona.setLongitude(2.183);
        barcelona.setLatitude(41.383);
        return barcelona;
    }


}
