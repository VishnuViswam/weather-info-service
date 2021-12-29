package com.service.weather.model.v1;


public class ThirdPartyApiResponseWithStatus {

    private ThirdPartyApiResponse data;

    private int apiStatus;

    public ThirdPartyApiResponseWithStatus() {
        super();
    }

    public ThirdPartyApiResponseWithStatus(ThirdPartyApiResponse data, int apiStatus) {
        this.data = data;
        this.apiStatus = apiStatus;
    }

    public ThirdPartyApiResponse getData() {
        return data;
    }

    public void setData(ThirdPartyApiResponse data) {
        this.data = data;
    }

    public int getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(int apiStatus) {
        this.apiStatus = apiStatus;
    }
}
