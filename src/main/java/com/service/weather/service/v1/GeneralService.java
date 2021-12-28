package com.service.weather.service.v1;

import com.service.weather.model.v1.ApiResponse;
import org.springframework.http.ResponseEntity;

/**
 * Interface where we declare the common operations.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public interface GeneralService {
    /**
     * To prepare Api response with status code
     * @param response
     * @return
     */
    ResponseEntity<Object> prepareHttpResponse(ApiResponse response);
}
