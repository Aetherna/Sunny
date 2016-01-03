package com.aethernadev.sunny.main.dailyforecast;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aethernadev.sunny.R;
import com.aethernadev.sunny.data.DayWeather;
import com.aethernadev.sunny.data.Location;

import java.util.List;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class DailyForecastAdapter extends ArrayAdapter<DayWeather> {

    private WeekDay weekDay;

    public DailyForecastAdapter(Context context, List<DayWeather> objects) {
        super(context, R.layout.daily_weather_item, objects);
        this.weekDay = new WeekDay(context);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = getViewHolder(position, convertView);
        ViewHolder holder = (ViewHolder) rowView.getTag();
        DayWeather dayWeather = getItem(position);

        fillHolder(holder, dayWeather);

        return rowView;
    }

    private void fillHolder(ViewHolder holder, DayWeather dayWeather) {

        int jodaDay = dayWeather.getDate().getDayOfWeek();
        int maxTemperature = dayWeather.getWeatherMinMAx().getTemperatureCelsiusMax();
        int minTemperature = dayWeather.getWeatherMinMAx().getTemperatureCelsiusMin();

        holder.dayName.setText(weekDay.getName(jodaDay));
        holder.dayTemp.setText(formatTempToCelsius(maxTemperature));
        holder.nightTemp.setText(formatTempToCelsius(minTemperature));
    }

    private String formatTempToCelsius(int temperature){
        return temperature + getContext().getResources().getString(R.string.celsius);
    }

    @NonNull
    private View getViewHolder(final int position, View convertView) {

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.daily_weather_item, null);

            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        return convertView;
    }

    private static class ViewHolder {
        TextView dayName;
        TextView dayTemp;
        TextView nightTemp;

        public ViewHolder(View rowView) {
            dayName = (TextView) rowView.findViewById(R.id.day_name);
            dayTemp = (TextView) rowView.findViewById(R.id.day_temp);
            nightTemp = (TextView) rowView.findViewById(R.id.night_temp);
        }
    }

}
