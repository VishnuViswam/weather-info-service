package com.service.weather.serviceImpl.v1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.service.weather.custom.exceptions.NoDataFoundException;
import com.service.weather.custom.exceptions.ThirdPartyApiException;
import com.service.weather.model.v1.*;
import com.service.weather.service.v1.ThirdPartyApiService;
import com.service.weather.service.v1.ValidationService;
import com.service.weather.service.v1.WeatherService;
import com.service.weather.utility.Constants;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private ThirdPartyApiService thirdPartyApiService;

    @Override
    @Cacheable(value = "WeatherData-byName", unless = "#result.getData() == null", key = "#cityName +#countryName")
    public ApiSuccessResponse getWeatherUsingCityAndCountry(String cityName, String countryName) {
        ApiSuccessResponse apiSuccessResponse = null;
        ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus;
        thirdPartyApiResponseWithStatus = thirdPartyApiService.getWeatherByCityAndCountryNames(cityName, countryName);
        apiSuccessResponse = processWeatherDataForApiResponse(thirdPartyApiResponseWithStatus);
        return apiSuccessResponse;
    }

    @Override
    @Cacheable(cacheNames = "WeatherData-byCoordinates", unless = "#result.getData() == null", key = "#lat +#lon")
    public ApiSuccessResponse getWeatherUsingCoordinates(String lat, String lon) {
        ApiSuccessResponse apiSuccessResponse = null;
        ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus;
        thirdPartyApiResponseWithStatus = thirdPartyApiService.getWeatherByCoordinates(lat, lon);
        apiSuccessResponse = processWeatherDataForApiResponse(thirdPartyApiResponseWithStatus);
        return apiSuccessResponse;
    }

    @Override
    public ApiSuccessResponse processWeatherDataForApiResponse(ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus) {
        ApiSuccessResponse apiSuccessResponse = null;
        apiSuccessResponse = new ApiSuccessResponse();
        if (thirdPartyApiResponseWithStatus != null) {
            if (thirdPartyApiResponseWithStatus.getApiStatus() == HttpStatus.OK.value()) {
                apiSuccessResponse.setData(thirdPartyApiResponseWithStatus.getData());
            } else if (thirdPartyApiResponseWithStatus.getApiStatus() == HttpStatus.NOT_FOUND.value()) {
                throw new NoDataFoundException(Constants.NO_DATA_FOUND_CODE, Constants.NO_DATA_FOUND_MESSAGE);
            } else {
                throw new ThirdPartyApiException(Constants.THIRD_PARTY_API_CALL_FAILED_CODE, Constants.THIRD_PARTY_API_CALL_FAILED_MESSAGE);
            }
        } else {
            throw new ThirdPartyApiException(Constants.THIRD_PARTY_API_CALL_FAILED_CODE, Constants.THIRD_PARTY_API_CALL_FAILED_MESSAGE);
        }
        return apiSuccessResponse;
    }
}
