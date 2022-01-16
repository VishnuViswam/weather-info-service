package com.service.weather.serviceImpl.v1;

import com.service.weather.model.v1.UserModel;
import com.service.weather.service.v1.ValidationService;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Interface implementation class of user account
 * The major [art of the business logics will be handled here.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@Service(value = "ValidationService")
@Scope(value = "prototype")
public class ValidationServiceImpl implements ValidationService {

    private static final Logger logger = LoggerFactory.getLogger(ValidationServiceImpl.class);




    @Override
    public boolean checkAPIResponseSuccessStatus(CloseableHttpResponse responses) {
        if (responses != null && responses.getStatusLine().getStatusCode() == HttpStatus.OK.value())
            return true;
        else {
            logger.error("Third party API Response: Error : API Status Code : " + responses.getStatusLine().getStatusCode());
            return false;
        }

    }
}
