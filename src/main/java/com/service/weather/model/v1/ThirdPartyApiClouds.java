package com.service.weather.model.v1;

import java.io.Serializable;

public class ThirdPartyApiClouds implements Serializable {
    private int all;

    public ThirdPartyApiClouds() {
        super();
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
