package com.service.weather.service.v1;

import com.service.weather.model.v1.ApiResponse;
import com.service.weather.model.v1.ApiSuccessResponse;
import com.service.weather.model.v1.ThirdPartyApiResponseWithStatus;

/**
 * Interface where we declare the weather related operations.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public interface WeatherService {
    /**
     * Method to get weather using city and country name
     *
     * @param cityName
     * @param countryName
     * @return
     */
    ApiSuccessResponse getWeatherUsingCityAndCountry(String cityName, String countryName);

    /**
     * Method to get weather using coordinates
     *
     * @param lat
     * @param lon
     * @return
     */
    ApiSuccessResponse getWeatherUsingCoordinates(String lat, String lon);

    /**
     * To process the weather data which is received from third party api
     *
     * @param thirdPartyApiResponseWithStatus
     * @return
     */
    ApiSuccessResponse processWeatherDataForApiResponse(ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus);
}
