package com.service.weather.utility;

public class Constants {

    // API common error codes
    public static final short UNKNOWN_ERROR_CODE = 0000;
    public static final short INCORRECT_DATA_CODE = 1000;
    public static final short NO_DATA_FOUND_CODE = 1001;
    public static final short DUPLICATE_DATA_ERROR_CODE = 1002;

    // API error cod for Third part API call
    public static final short THIRD_PARTY_API_CALL_FAILED = 2000;

    // API common error messages
    public static final String NO_DATA_FOUND_MESSAGE = "No data found";
    public static final String UNKNOWN_ERROR_MESSAGE = "Something went wrong";
    public static final String INCORRECT_DATA_MESSAGE = "Incorrect data";
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "Name already exist";

    // API error messages for Third part API call
    public static final String THIRD_PARTY_API_CALL_FAILED_MESSAGE = "Third party API call failed";

    // Status code for Active
    public static final boolean ACTIVE_STATUS = true;
    public static final boolean IN_ACTIVE_STATUS = false;
    public static final long DEFAULT_USER_ACCOUNT_ID = 0;

    public static final String UNIQUE_CONSTRAINT_ERROR = "UNIQUE KEY constraint";
    public static final String DEFAULT_USER_ROLE = "USER";

    // weather api details
    public static final String WEATHER_API_NAME_KEY = "q";
    public static final String WEATHER_API_API_ID_KEY = "appid";
    public static final String WEATHER_API_LAT_KEY = "lat";
    public static final String WEATHER_API_LON_KEY = "lon";
    public static final String HTTP = "http://";
}
