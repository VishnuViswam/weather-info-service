package com.service.weather.serviceImpl.v1;

import com.service.weather.model.v1.ApiResponse;
import com.service.weather.service.v1.GeneralService;
import com.service.weather.utility.Constants;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Interface implementation class of common operations
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@Service(value = "GeneralService")
@Scope(value = "prototype")
public class GeneralServiceImpl implements GeneralService {
    @Override
    public ResponseEntity<Object> prepareHttpResponse(ApiResponse response) {
        if (response.getError() != null) {
            if (Constants.UNKNOWN_ERROR_CODE == response.getError().getError()
                    || Constants.THIRD_PARTY_API_CALL_FAILED == response.getError().getError()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response.getError());
            } else if (Constants.INCORRECT_DATA_CODE == response.getError().getError()
                    || Constants.DUPLICATE_DATA_ERROR_CODE == response.getError().getError()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.getError());
            }
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(response.getSuccess());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
