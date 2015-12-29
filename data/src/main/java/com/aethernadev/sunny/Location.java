package com.aethernadev.sunny;

import java.io.Serializable;

/**
 * Created by Aetherna on 2015-12-27.
 */
public class Location implements Serializable {

    private String name = "";
    private String country = "";
    private String region = "";
    private double latitude;
    private double longitude;

    public boolean isEmpty() {
        return name.isEmpty() && country.isEmpty() && region.isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
