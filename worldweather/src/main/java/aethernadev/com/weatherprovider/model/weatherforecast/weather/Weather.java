package aethernadev.com.weatherprovider.model.weatherforecast.weather;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class Weather {

    private List<Astronomy> astronomy;
    private String date;
    private List<Hourly> hourly;
    private int maxtempC;
    private int maxtempF;
    private int mintempC;
    private int mintempF;
    private String uvIndex;

    public List<Astronomy> getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(List<Astronomy> astronomy) {
        this.astronomy = astronomy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    public int getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(int maxtempC) {
        this.maxtempC = maxtempC;
    }

    public int getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(int maxtempF) {
        this.maxtempF = maxtempF;
    }

    public int getMintempC() {
        return mintempC;
    }

    public void setMintempC(int mintempC) {
        this.mintempC = mintempC;
    }

    public int getMintempF() {
        return mintempF;
    }

    public void setMintempF(int mintempF) {
        this.mintempF = mintempF;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }
}
