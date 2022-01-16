package com.service.weather.controller;

import com.service.weather.custom.exceptions.NoDataFoundException;
import com.service.weather.custom.exceptions.ThirdPartyApiException;
import com.service.weather.model.v1.ApiErrorResponse;
import com.service.weather.utility.Constants;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Calendar;
import java.util.NoSuchElementException;

/**
 * This class is common exception handling controller
 * all general type exceptions will be handled here.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-28
 */
@ControllerAdvice
public class CommonExceptionHandlingController extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandlingController.class);

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorResponse(Constants.WRONG_HTTP_METHOD,
                Constants.WRONG_HTTP_METHOD_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiErrorResponse(Constants.MANDATORY_FIELDS_ARE_NOT_PRESENT_CODE,
                Constants.MANDATORY_FIELDS_ARE_NOT_PRESENT_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException nullPointerException) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiErrorResponse(Constants.UNKNOWN_ERROR_CODE,
                Constants.UNKNOWN_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiErrorResponse(Constants.INCORRECT_DATA_CODE,
                Constants.INCORRECT_DATA_MESSAGE, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException noDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorResponse(Constants.NO_DATA_FOUND_CODE,
                Constants.NO_DATA_FOUND_MESSAGE, Calendar.getInstance().getTimeInMillis()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
        if (dataIntegrityViolationException.getMessage().equalsIgnoreCase(String.valueOf(Constants.UNIQUE_NAME_ERROR_CODE))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiErrorResponse(Constants.UNIQUE_NAME_ERROR_CODE,
                    Constants.UNIQUE_NAME_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
        } else {
            logger.error(" <-------------- Unknown exception happened ---------------->  ", dataIntegrityViolationException);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiErrorResponse(Constants.INCORRECT_DATA_CODE,
                    Constants.INCORRECT_DATA_MESSAGE, Calendar.getInstance().getTimeInMillis()));
        }
    }

    @ExceptionHandler(ThirdPartyApiException.class)
    public ResponseEntity<Object> handleThirdPartyApiException(ThirdPartyApiException thirdPartyApiException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorResponse(Constants.THIRD_PARTY_API_CALL_FAILED_CODE,
                Constants.THIRD_PARTY_API_CALL_FAILED_MESSAGE, Calendar.getInstance().getTimeInMillis()));
    }


    /**
     * To handle all other unknown exceptions
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCommonException(Exception exception) {
        logger.error(" <-------------- Unknown exception happened ---------------->  ", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiErrorResponse(Constants.UNKNOWN_ERROR_CODE,
                Constants.UNKNOWN_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
    }

}
