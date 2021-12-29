package com.service.weather.serviceImpl.v1;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.weather.model.v1.ThirdPartyApiResponse;
import com.service.weather.model.v1.ThirdPartyApiResponseWithStatus;
import com.service.weather.service.v1.ThirdPartyApiService;
import com.service.weather.service.v1.ValidationService;
import com.service.weather.utility.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface implementation class of third party Api call related operations.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@Service(value = "ThirdPartyApiService")
@Scope(value = "prototype")
public class ThirdPartyApiServiceImpl implements ThirdPartyApiService {

    private static final Logger logger = LogManager.getLogger(ThirdPartyApiService.class);

    @Value("${weather.api.base.url}")
    private String weatherApiBaseUrl;

    @Value("${weather.api.key}")
    private String weatherApiKey;

    @Autowired
    private ValidationService validationService;

    @Override
    public ThirdPartyApiResponseWithStatus getWeatherByCityAndCountryNames(String cityName, String countryName) {
        ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus = null;
        ThirdPartyApiResponse thirdPartyApiResponse = null;
        JsonObject jsonObject = null;
        JsonParser parser = new JsonParser();
        Gson gson = null;

        CloseableHttpClient closeableHttpClient = null;
        URI uri = null;
        HttpGet httpGet = null;
        List<NameValuePair> params = null;
        CloseableHttpResponse response = null;
        HttpEntity responseEntity = null;
        try {
            httpGet = new HttpGet(Constants.HTTP + weatherApiBaseUrl);
            // Request parameters and other properties.
            params = new ArrayList<>();
            params.add(new BasicNameValuePair(Constants.WEATHER_API_NAME_KEY, String.valueOf(cityName + "," + countryName)));
            params.add(new BasicNameValuePair(Constants.WEATHER_API_API_ID_KEY, String.valueOf(weatherApiKey)));
            uri = new URIBuilder(httpGet.getURI())
                    .addParameters(params)
                    .build();
            ((HttpRequestBase) httpGet).setURI(uri);
            closeableHttpClient = HttpClients.createDefault();
            response = closeableHttpClient.execute(httpGet);

            if (validationService.checkAPIResponseSuccessStatus(response)) {
                // Extracting response data from API
                responseEntity = response.getEntity();

                // Response data is assigned to a json object
                jsonObject = parser.parse(EntityUtils.toString(responseEntity, "UTF-8")).getAsJsonObject();
                gson = new Gson();
                thirdPartyApiResponse = gson.fromJson(jsonObject.toString(), ThirdPartyApiResponse.class);
            }
            thirdPartyApiResponseWithStatus = new ThirdPartyApiResponseWithStatus(thirdPartyApiResponse, response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            logger.error("Third party API execution : Exception ", e);
        } finally {
            if (closeableHttpClient != null) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    logger.error("Third party API execution: Exception : ", e);
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("Third party API execution: Exception : ", e);
                }
            }
        }
        return thirdPartyApiResponseWithStatus;
    }

    @Override
    public ThirdPartyApiResponseWithStatus getWeatherByCoordinates(String lat, String lon) {
        ThirdPartyApiResponseWithStatus thirdPartyApiResponseWithStatus = null;
        ThirdPartyApiResponse thirdPartyApiResponse = null;
        JsonObject jsonObject = null;
        JsonParser parser = new JsonParser();
        Gson gson = null;

        CloseableHttpClient closeableHttpClient = null;
        URI uri = null;
        HttpGet httpGet = null;
        List<NameValuePair> params = null;
        CloseableHttpResponse response = null;
        HttpEntity responseEntity = null;
        try {
            httpGet = new HttpGet(Constants.HTTP + weatherApiBaseUrl);
            // Request parameters and other properties.
            params = new ArrayList<>();
            params.add(new BasicNameValuePair(Constants.WEATHER_API_LAT_KEY, String.valueOf(lat)));
            params.add(new BasicNameValuePair(Constants.WEATHER_API_LON_KEY, String.valueOf(lon)));
            params.add(new BasicNameValuePair(Constants.WEATHER_API_API_ID_KEY, String.valueOf(weatherApiKey)));
            uri = new URIBuilder(httpGet.getURI())
                    .addParameters(params)
                    .build();
            ((HttpRequestBase) httpGet).setURI(uri);
            closeableHttpClient = HttpClients.createDefault();
            response = closeableHttpClient.execute(httpGet);

            if (validationService.checkAPIResponseSuccessStatus(response)) {
                // Extracting response data from API
                responseEntity = response.getEntity();

                // Response data is assigned to a json object
                jsonObject = parser.parse(EntityUtils.toString(responseEntity, "UTF-8")).getAsJsonObject();
                gson = new Gson();
                thirdPartyApiResponse = gson.fromJson(jsonObject.toString(), ThirdPartyApiResponse.class);
            }
            thirdPartyApiResponseWithStatus = new ThirdPartyApiResponseWithStatus(thirdPartyApiResponse, response.getStatusLine().getStatusCode());
        } catch (Exception e) {
            logger.error("Third party API execution : Exception ", e);
        } finally {
            if (closeableHttpClient != null) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    logger.error("Third party API execution: Exception : ", e);
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("Third party API execution: Exception : ", e);
                }
            }
        }
        return thirdPartyApiResponseWithStatus;
    }

}
