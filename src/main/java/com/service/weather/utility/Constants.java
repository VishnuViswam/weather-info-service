package com.service.weather.utility;

public class Constants {

    // API common error codes
    public static final short UNKNOWN_ERROR_CODE = 0000;
    public static final short UNAUTHORIZED_USER_CODE = 1000;
    public static final short INCORRECT_DATA_CODE = 1001;
    public static final short NO_DATA_FOUND_CODE = 1002;
    public static final short DUPLICATE_DATA_ERROR_CODE = 1003;
    public static final short WRONG_HTTP_METHOD = 1004;
    public static final short MANDATORY_FIELDS_ARE_NOT_PRESENT_CODE = 1005;

    // API error codes and messages for Third part API call
    public static final short THIRD_PARTY_API_CALL_FAILED_CODE = 2000;
    public static final String THIRD_PARTY_API_CALL_FAILED_MESSAGE = "Third party API call failed";

    // Unique Field exception codes and messages
    public static final short UNIQUE_NAME_ERROR_CODE = 3000;
    public static final String UNIQUE_NAME_ERROR_MESSAGE = "User name already exist";

    // API common error messages
    public static final String NO_DATA_FOUND_MESSAGE = "No data found";
    public static final String UNKNOWN_ERROR_MESSAGE = "Something went wrong";
    public static final String UNAUTHORIZED_USER_ERROR_MESSAGE = "Unauthorized access";
    public static final String INCORRECT_DATA_MESSAGE = "Incorrect data";
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "Name already exist";
    public static final String WRONG_HTTP_METHOD_ERROR_MESSAGE = "HTTP method is wrong";
    public static final String MANDATORY_FIELDS_ARE_NOT_PRESENT_ERROR_MESSAGE = "Mandatory fields are not present";


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
