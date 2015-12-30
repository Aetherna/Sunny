package aethernadev.com.weatherprovider.model.weatherforecast.climateaverages;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class MonthAverage {
    private String absMaxTemp;
    private String absMaxTemp_F;
    private String avgMinTemp;
    private String avgMinTemp_F;
    private String ndex;
    private String name;

    public String getAbsMaxTemp() {
        return absMaxTemp;
    }

    public void setAbsMaxTemp(String absMaxTemp) {
        this.absMaxTemp = absMaxTemp;
    }

    public String getAbsMaxTemp_F() {
        return absMaxTemp_F;
    }

    public void setAbsMaxTemp_F(String absMaxTemp_F) {
        this.absMaxTemp_F = absMaxTemp_F;
    }

    public String getAvgMinTemp() {
        return avgMinTemp;
    }

    public void setAvgMinTemp(String avgMinTemp) {
        this.avgMinTemp = avgMinTemp;
    }

    public String getAvgMinTemp_F() {
        return avgMinTemp_F;
    }

    public void setAvgMinTemp_F(String avgMinTemp_F) {
        this.avgMinTemp_F = avgMinTemp_F;
    }

    public String getNdex() {
        return ndex;
    }

    public void setNdex(String ndex) {
        this.ndex = ndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
