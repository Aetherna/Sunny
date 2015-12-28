package aethernadev.com.weatherprovider.model.searchlocation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Aetherna.
 */
public class ResponseLocation {

    @SerializedName(value = "areaName")
    private List<SingleValue> name;
    private List<SingleValue> country;
    private List<SingleValue> region;
    private double latitude;
    private double longitude;
    private int population;
    private List<SingleValue> weatherUrl;

    public static class SingleValue {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public List<SingleValue> getName() {
        return name;
    }

    public void setName(List<SingleValue> name) {
        this.name = name;
    }

    public List<SingleValue> getCountry() {
        return country;
    }

    public void setCountry(List<SingleValue> country) {
        this.country = country;
    }

    public List<SingleValue> getRegion() {
        return region;
    }

    public void setRegion(List<SingleValue> region) {
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<SingleValue> getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(List<SingleValue> weatherUrl) {
        this.weatherUrl = weatherUrl;
    }
}
