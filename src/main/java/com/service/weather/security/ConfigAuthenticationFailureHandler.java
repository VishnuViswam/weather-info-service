package com.service.weather.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.weather.model.v1.ApiErrorResponse;
import com.service.weather.utility.Constants;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

@Component
public class ConfigAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(Constants.UNAUTHORIZED_USER_CODE,
                Constants.UNAUTHORIZED_USER_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis());
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        OutputStream out = httpServletResponse.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(out, apiErrorResponse);
        out.flush();
    }
}
