package com.service.weather.serviceImpl.v1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.service.weather.model.v1.*;
import com.service.weather.service.v1.ThirdPartyApiService;
import com.service.weather.service.v1.ValidationService;
import com.service.weather.service.v1.WeatherService;
import com.service.weather.utility.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Interface implementation class of weather related operations.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@Service(value = "WeatherService")
@Scope(value = "prototype")
public class WeatherServiceImpl implements WeatherService {

    private static final Logger logger = LogManager.getLogger(WeatherService.class);

    @Autowired
    private ThirdPartyApiService thirdPartyApiService;

    @Override
    public ApiResponse getWeatherUsingCityAndCountry(String cityName, String countryName) {
        ApiResponse apiResponse = null;
        ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus;
        thirdPartyApiResponseWithStatus = thirdPartyApiService.getWeatherByCityAndCountryNames(cityName, countryName);
        return processWeatherDataForApiResponse(thirdPartyApiResponseWithStatus);
    }

    @Override
    public ApiResponse getWeatherUsingCoordinates(String lat, String lon) {
        ApiResponse apiResponse = null;
        ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus;
        thirdPartyApiResponseWithStatus = thirdPartyApiService.getWeatherByCoordinates(lat, lon);
        return processWeatherDataForApiResponse(thirdPartyApiResponseWithStatus);
    }

    @Override
    public ApiResponse processWeatherDataForApiResponse(ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus) {
        ApiResponse apiResponse = null;
        ThirdPartyApiResponse thirdPartyApiResponse = null;
        Gson gson = null;
        try {
            apiResponse = new ApiResponse();
            if (thirdPartyApiResponseWithStatus != null) {
                if (thirdPartyApiResponseWithStatus.getApiStatus() == HttpStatus.OK.value()) {
                    gson = new Gson();
                    thirdPartyApiResponse = gson.fromJson(thirdPartyApiResponseWithStatus.getData().toString(), ThirdPartyApiResponse.class);
                    apiResponse.setSuccess(new ApiSuccessResponse(thirdPartyApiResponse));
                } else {
                    apiResponse.setError(new ApiErrorResponse(Constants.THIRD_PARTY_API_CALL_FAILED,
                            Constants.THIRD_PARTY_API_CALL_FAILED_MESSAGE, Calendar.getInstance().getTimeInMillis()));
                }
            } else {
                apiResponse.setError(new ApiErrorResponse(Constants.THIRD_PARTY_API_CALL_FAILED,
                        Constants.THIRD_PARTY_API_CALL_FAILED_MESSAGE, Calendar.getInstance().getTimeInMillis()));
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse();
            apiResponse.setError(new ApiErrorResponse(Constants.UNKNOWN_ERROR_CODE,
                    Constants.UNKNOWN_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
        }
        return apiResponse;
    }
}
