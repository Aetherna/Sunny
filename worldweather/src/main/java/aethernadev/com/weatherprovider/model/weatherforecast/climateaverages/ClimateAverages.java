package aethernadev.com.weatherprovider.model.weatherforecast.climateaverages;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class ClimateAverages {

    @SerializedName("month")
    private List<MonthAverage> monthAverages;

    public List<MonthAverage> getMonthAverages() {
        return monthAverages;
    }

    public void setMonthAverages(List<MonthAverage> monthAverages) {
        this.monthAverages = monthAverages;
    }
}
