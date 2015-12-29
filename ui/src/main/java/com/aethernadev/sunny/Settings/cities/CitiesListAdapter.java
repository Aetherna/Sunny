package com.aethernadev.sunny.settings.cities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.R;

/**
 * Created by Aetherna.
 */
public class CitiesListAdapter extends ArrayAdapter<Location> {
    private LocationDeletedListener listener;

    public CitiesListAdapter(Context context, LocationDeletedListener listener) {
        super(context, R.layout.settings_city_item);
        this.listener = listener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = getViewHolder(position, convertView);
        ViewHolder holder = (ViewHolder) rowView.getTag();
        Location location = getItem(position);

        fillHolder(holder, location);

        return rowView;
    }

    private void fillHolder(ViewHolder holder, Location location) {
        holder.name.setText(location.getName());

        String details = location.getRegion();
        if (details.isEmpty()) {
            details = location.getCountry();
        }
        holder.details.setText(details);
    }

    @NonNull
    private View getViewHolder(final int position, View convertView) {

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.settings_city_item, null);

            ViewHolder viewHolder = new ViewHolder(convertView);
            viewHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onLocationDeleted(getItem(position));
                }
            });
            convertView.setTag(viewHolder);
        }
        return convertView;
    }

    private static class ViewHolder {
        TextView name;
        TextView details;
        ImageButton delete;

        public ViewHolder(View rowView) {
            name = (TextView) rowView.findViewById(R.id.locationName);
            details = (TextView) rowView.findViewById(R.id.locationDetails);
            delete = (ImageButton) rowView.findViewById(R.id.deleteLocation);
        }
    }

    public interface LocationDeletedListener {
        void onLocationDeleted(Location location);
    }

}
