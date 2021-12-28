package com.service.weather.service.v1;

import com.service.weather.entity.UserAccounts;
import com.service.weather.model.v1.ApiResponse;
import com.service.weather.model.v1.ApiSuccessResponse;
import com.service.weather.model.v1.UserModel;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * Interface where we declare the different operations of user account
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public interface UserAccountsService {
    /**
     * Method to save new user
     *
     * @param userModel
     * @return
     */
    ApiResponse userRegistration(UserModel userModel);

    /**
     * Method prepare Api out put data from user entity object
     *
     * @param userAccount
     * @return
     */
    ApiSuccessResponse prepareApiOutPutData(UserAccounts userAccount) throws Exception;

    /**
     * To get a user using email and status
     *
     * @param name
     * @param status
     * @return
     */
    Optional<UserAccounts> getUserByNameAndStatus(String name, boolean status);
}
