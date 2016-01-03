package com.aethernadev.sunny.settings.cities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aetherna.
 */
public class SelectLocationDialog extends DialogFragment {

    public static final String LOCATIONS = "locations";
    private List<Location> locations;

    private LocationSelectedListener listener;

    public static SelectLocationDialog getInstance(List<Location> locations) {
        SelectLocationDialog frag = new SelectLocationDialog();
        Bundle args = new Bundle();
        args.putSerializable(LOCATIONS, (Serializable) locations);
        frag.setArguments(args);
        return frag;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        this.locations = (List<Location>) getArguments().getSerializable(LOCATIONS);
        try {
            this.listener = (LocationSelectedListener) getTargetFragment();
        } catch (ClassCastException ex) {
            throw new RuntimeException("Fragment must implement LocationSelectedListener!");
        }

        return getSelectionDialog();
    }

    private Dialog getSelectionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getTitle());
        builder.setItems(getLocationsDetails(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onLocationSelected(locations.get(which));
            }
        });
        return builder.create();
    }

    private String getTitle() {
        final String title = getActivity().getString(R.string.multiple_locations_found);
        final String locationName = locations.get(0).getName();
        return String.format(title, locationName);
    }

    private String[] getLocationsDetails() {
        List<String> results = new ArrayList<>(locations.size());
        for (Location location : locations) {
            if (!location.getRegion().isEmpty()) {
                results.add(location.getRegion());
            } else {
                results.add(location.getCountry());
            }
        }
        return results.toArray(new String[results.size()]);
    }

    public interface LocationSelectedListener {
        void onLocationSelected(Location location);
    }
}
