package aethernadev.com.weatherprovider.model.searchlocation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Aetherna.
 */
public class SearchResult {

    @SerializedName(value = "result")
    private List<ResponseLocation> locations;

    public List<ResponseLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<ResponseLocation> locations) {
        this.locations = locations;
    }
}
