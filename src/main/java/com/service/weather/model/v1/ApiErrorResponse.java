package com.service.weather.model.v1;

import java.io.Serializable;

/**
 * When API is failed ,
 * This class will be returned to the client as API response.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public class ApiErrorResponse implements Serializable {

    private short error;

    private String error_message;

    private long timestamp;

    public short getError() {
        return error;
    }

    public ApiErrorResponse(short error, String error_message, long timestamp) {
        this.error = error;
        this.error_message = error_message;
        this.timestamp = timestamp;
    }

    public void setError(short error) {
        this.error = error;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
