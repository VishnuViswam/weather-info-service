package com.service.weather.controller.v1;

import com.service.weather.model.v1.ApiSuccessResponse;
import com.service.weather.model.v1.UserModel;
import com.service.weather.service.v1.GeneralService;
import com.service.weather.service.v1.UserAccountsService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Api controller class where all APIs related to user will be received here.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@RestController
@RequestMapping("v1/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserAccountsService userAccountsService;

    @Autowired
    private GeneralService generalService;

    /**
     * API to register a new user
     *
     * @param userModel
     * @return
     */
    @PostMapping(value = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createClient(@Valid @RequestBody UserModel userModel) {
        logger.debug("<--- Service to user registration request : received --->");
        ApiSuccessResponse apiSuccessResponse = userAccountsService.userRegistration(userModel);
        logger.debug("<--- Service to user registration response : given --->");
        return ResponseEntity.status(HttpStatus.CREATED).body(apiSuccessResponse);

    }

}
