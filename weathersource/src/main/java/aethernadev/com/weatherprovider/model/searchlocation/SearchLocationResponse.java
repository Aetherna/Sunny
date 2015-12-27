package aethernadev.com.weatherprovider.model.searchlocation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aetherna on 2015-12-27.
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
