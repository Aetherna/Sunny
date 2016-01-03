package aethernadev.com.weatherprovider.model.weatherforecast.currentcondition;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import aethernadev.com.weatherprovider.model.SingleValue;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class CurrentCondition {
    @SerializedName("observation_time")
    private String observationTime;
    @SerializedName("temp_C")
    private int tempInC;
    private String weatherCode;
    public List<SingleValue> weatherIconUrl;
    public List<SingleValue> weatherDesc;
    private String windspeedMiles;
    private String windspeedKmph;
    private String winddirDegree;
    private String winddir16Point;
    private String precipMM;
    private String humidity;
    private String visibility;
    private double pressure;
    private String cloudcover;

    public String getObservationTime() {
        return observationTime;
    }

    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getWinddirDegree() {
        return winddirDegree;
    }

    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public int getTempInC() {
        return tempInC;
    }

    public void setTempInC(int tempInC) {
        this.tempInC = tempInC;
    }

    public List<SingleValue> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(List<SingleValue> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public List<SingleValue> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(List<SingleValue> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }
}
