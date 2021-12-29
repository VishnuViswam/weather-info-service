package com.service.weather.model.v1;

import java.io.Serializable;

public class ThirdPartyAPICoord implements Serializable {
    private double lon;
    private double lat;

    public ThirdPartyAPICoord() {
        super();
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
