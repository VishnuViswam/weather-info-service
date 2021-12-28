package com.service.weather.service.v1;

import com.service.weather.model.v1.ThirdPartyApiResponseWithStatus;

/**
 * Interface where we declare the third party Api call related operations.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public interface ThirdPartyApiService {
    /**
     * To get weather details using city and country names
     *
     * @param cityName
     * @param countryName
     * @return
     */
    ThirdPartyApiResponseWithStatus getWeatherByCityAndCountryNames(String cityName, String countryName);

    /**
     * o get weather details using coordinates
     *
     * @param lat
     * @param lon
     * @return
     */
    ThirdPartyApiResponseWithStatus getWeatherByCoordinates(String lat, String lon);


}
