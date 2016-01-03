package com.aethernadev.sunny.settings.cities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aethernadev.sunny.R;
import com.aethernadev.sunny.SunnyApp;
import com.aethernadev.sunny.data.Location;
import com.aethernadev.sunny.presenter.error.PrintableError;
import com.aethernadev.sunny.presenter.settings.SettingsCitiesPresenter;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SettingsCitiesFragment extends Fragment implements CitiesListAdapter.LocationDeletedListener, SelectLocationDialog.LocationSelectedListener, SettingsCitiesPresenter.SettingsUI {


    public static final String SELECTED_LOCATIONS = "SelectedLocations";
    public static final String SELECTION_DIALOG = "dialog";
    @Bind(R.id.city_input)
    EditText cityInput;
    @Bind(R.id.search_city)
    Button searchCity;
    @Bind(R.id.selected_cities)
    ListView selectedCities;
    @Bind(R.id.loading)
    ProgressBar loading;
    @Bind(R.id.error_message)
    TextView errorMessage;

    @Inject
    SettingsCitiesPresenter presenter;
    private CitiesListAdapter adapter;

    public SettingsCitiesFragment() {
    }

    public static SettingsCitiesFragment newInstance() {
        SettingsCitiesFragment fragment = new SettingsCitiesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings_cities, container, false);
        ButterKnife.bind(this, view);
        ((SunnyApp) getActivity().getApplication()).getAppComponent().inject(this);

        adapter = new CitiesListAdapter(getActivity(), this);
        selectedCities.setAdapter(adapter);
        setupPresenter(savedInstanceState);
        return view;
    }

    private void setupPresenter(Bundle savedInstanceState) {
        presenter.attachUI(this);
        if (savedInstanceState == null) {
            presenter.loadSavedLocations();
        } else {
            List<Location> selectedLocations = (List<Location>) savedInstanceState.getSerializable(SELECTED_LOCATIONS);
            presenter.setSelectedLocations(selectedLocations);
        }
    }

    @Override
    public void onLocationDeleted(Location location) {
        adapter.remove(location);
        presenter.onRemoveLocation(location);
    }

    @Override
    public void addLocation(Location location) {
        adapter.add(location);
    }

    @Override
    public void setLocations(List<Location> locations) {
        adapter.clear();
        adapter.addAll(locations);
    }

    @Override
    public void showError(PrintableError error) {
        errorMessage.setText(error.getMessage(getContext()));
    }

    @Override
    public void showLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void hideError() {
        errorMessage.setText("");
    }

    @Override
    public void selectOneFromLocations(List<Location> locations) {
        SelectLocationDialog dialogFrag = SelectLocationDialog.getInstance(locations);
        dialogFrag.setTargetFragment(this, 1);
        dialogFrag.show(getFragmentManager().beginTransaction(), SELECTION_DIALOG);
    }

    @OnClick(R.id.search_city)
    public void searchCity(View view) {

        if (validateInputField()) {
            presenter.onLocationSearch(cityInput.getText().toString());
        }
    }

    private boolean validateInputField() {
        hideError();
        if (cityInput.getText().toString().trim().isEmpty()) {
            errorMessage.setText(getActivity().getString(R.string.insert_value));
            return false;
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(SELECTED_LOCATIONS, (Serializable) presenter.getSelectedLocations());
    }

    @Override
    public void onLocationSelected(Location location) {
        presenter.addSelectedLocation(location);
    }

    public List<Location> getUserSelectedLocations() {
        return presenter.getSelectedLocations();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachUI(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachUI();
    }
}
