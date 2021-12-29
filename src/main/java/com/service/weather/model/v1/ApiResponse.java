package com.service.weather.model.v1;

import java.io.Serializable;

/**
 * This class will hold bot API success and failed response data.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public class ApiResponse implements Serializable {

    private ApiErrorResponse error;

    private ApiSuccessResponse success;

    public ApiResponse() {
        super();
    }

    public ApiResponse(ApiErrorResponse error, ApiSuccessResponse success) {
        this.error = error;
        this.success = success;
    }

    public ApiErrorResponse getError() {
        return error;
    }

    public void setError(ApiErrorResponse error) {
        this.error = error;
    }

    public ApiSuccessResponse getSuccess() {
        return success;
    }

    public void setSuccess(ApiSuccessResponse success) {
        this.success = success;
    }
}
