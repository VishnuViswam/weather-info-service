package com.service.weather.model.v1;

import com.google.gson.JsonObject;

public class ThirdPartyApiResponseWithStatus {

    private JsonObject data;

    private int apiStatus;

    public ThirdPartyApiResponseWithStatus() {
        super();
    }

    public ThirdPartyApiResponseWithStatus(JsonObject data, int apiStatus) {
        this.data = data;
        this.apiStatus = apiStatus;
    }

    public JsonObject getData() {
        return data;
    }

    public void setData(JsonObject data) {
        this.data = data;
    }

    public int getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(int apiStatus) {
        this.apiStatus = apiStatus;
    }
}
