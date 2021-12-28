package com.service.weather.model.v1;

/**
 * When API is success ,
 * This class will be returned to the client as API response.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public class ApiSuccessResponse {
    private Object data;

    public ApiSuccessResponse(Object data) {
        this.data = data;
    }

    public ApiSuccessResponse() {
        super();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
