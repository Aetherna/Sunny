package aethernadev.com.weatherprovider.model.weatherforecast.request;

/**
 * Created by Aetherna on 2015-12-30.
 */
public class Request {
    private String type;
    private String query;

    Request() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
