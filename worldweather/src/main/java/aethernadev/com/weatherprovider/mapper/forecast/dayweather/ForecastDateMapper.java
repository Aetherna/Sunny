package aethernadev.com.weatherprovider.mapper.forecast.dayweather;

import android.util.Log;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.inject.Inject;

/**
 * Created by Aetherna.
 */
public class ForecastDateMapper {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    @Inject
    public ForecastDateMapper() {
    }

   public DateTime from(String date) {

        if (date == null) {
            Log.e(ForecastDateMapper.class.getSimpleName(), "Nulled date! returning now");
            return DateTime.now();
        }

        DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE_FORMAT);
        return formatter.parseDateTime(date);
    }
}
