package com.service.weather.service.v1;

import com.service.weather.model.v1.UserModel;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;

/**
 * Interface where we declare all server side Api validations.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public interface ValidationService {

    /**
     * To validate user registration Api request
     * @param userModel
     * @return
     */
    boolean validateUseRegistration(UserModel userModel);

    /**
     * To check the API response HTTP status
     *
     * @param responses
     * @return
     */
    boolean checkAPIResponseSuccessStatus(CloseableHttpResponse responses);
}
