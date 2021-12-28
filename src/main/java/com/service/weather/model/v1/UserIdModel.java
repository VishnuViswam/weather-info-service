package com.service.weather.model.v1;

/**
 * This is a custom model which having only user account Id.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public class UserIdModel {

    private long userId;

    public UserIdModel() {
        super();
    }

    public UserIdModel(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
