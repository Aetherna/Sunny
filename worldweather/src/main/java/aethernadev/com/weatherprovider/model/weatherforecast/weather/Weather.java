package aethernadev.com.weatherprovider.model.weatherforecast.weather;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class Weather {

    public List<Astronomy> astronomy;
    public String date;
    public List<Hourly> hourly;
    public String maxtempC;
    public String maxtempF;
    public String mintempC;
    public String mintempF;
    public String uvIndex;

}
