package aethernadev.com.weatherprovider.model.searchlocation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aetherna.
 */
public class SearchLocationResponse {

    @SerializedName(value = "search_api")
    private SearchResult searchResult;

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }
}
