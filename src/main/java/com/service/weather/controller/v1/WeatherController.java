package com.service.weather.controller.v1;

import com.service.weather.model.v1.ApiResponse;
import com.service.weather.service.v1.GeneralService;
import com.service.weather.service.v1.WeatherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Api controller class where all APIs related to weather will be received here.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@RestController
@RequestMapping("v1/weather")
public class WeatherController {

    private static final Logger logger = LogManager.getLogger(WeatherController.class);

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private GeneralService generalService;

    /**
     * Api to get weather using city and country name
     *
     * @param cityName
     * @param countryName
     * @return
     */
    @GetMapping(value = "/cityAndCountry", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getWeatherByCityAndCountryName(@RequestParam(name = "cityName", required = true) String cityName,
                                                                 @RequestParam(name = "countryName", required = true) String countryName) {
        logger.debug("<--- Service to get weather using city and country request : received --->");
        ApiResponse response = weatherService.getWeatherUsingCityAndCountry(cityName, countryName);
        logger.debug("<--- Service to get weather using city and country response : given --->");
        return generalService.prepareHttpResponse(response);

    }

    /**
     * Api to get weather using coordinates
     *
     * @param lon
     * @param lat
     * @return
     */
    @GetMapping(value = "/coordinates", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getWeatherByCoordinates(@RequestParam(name = "lat", required = true) String lat,
                                                          @RequestParam(name = "lon", required = true) String lon) {
        logger.debug("<--- Service to get weather using city and country request : received --->");
        ApiResponse response = weatherService.getWeatherUsingCoordinates(lat, lon);
        logger.debug("<--- Service to get weather using city and country response : given --->");
        return generalService.prepareHttpResponse(response);

    }

}
