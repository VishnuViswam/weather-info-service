package com.service.weather.serviceImpl.v1;

import com.service.weather.entity.UserAccounts;
import com.service.weather.model.v1.*;
import com.service.weather.repository.UserAccountsRepository;
import com.service.weather.service.v1.PasswordHashingService;
import com.service.weather.service.v1.UserAccountsService;
import com.service.weather.service.v1.ValidationService;
import com.service.weather.utility.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

/**
 * Interface implementation class of user account
 * The major [art of the business logics will be handled here.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@Service(value = "UserAccountsService")
@Scope(value = "prototype")
public class UserAccountsServiceImpl implements UserAccountsService {

    private static final Logger logger = LogManager.getLogger(UserAccountsServiceImpl.class);

    @Autowired
    private UserAccountsRepository userAccountsRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PasswordHashingService passwordHashingService;

    @Override
    public ApiResponse userRegistration(UserModel userModel) {
        ApiResponse apiResponse = null;
        UserAccounts userAccounts = null;
        String password = null;
        try {
            if (validationService.validateUseRegistration(userModel)) {
                password = passwordHashingService.encode(userModel.getPassword());
                userAccounts = new UserAccounts(userModel.getName(), userModel.getEmail(), password, Constants.ACTIVE_STATUS,
                        Calendar.getInstance(), Constants.DEFAULT_USER_ACCOUNT_ID, Calendar.getInstance(), Constants.DEFAULT_USER_ACCOUNT_ID);
                userAccountsRepository.save(userAccounts);
                apiResponse = new ApiResponse();
                apiResponse.setSuccess(new ApiSuccessResponse(new UserIdModel(userAccounts.getId())));
            } else {
                apiResponse = new ApiResponse();
                apiResponse.setError(new ApiErrorResponse(Constants.INCORRECT_DATA_CODE, Constants.INCORRECT_DATA_MESSAGE, Calendar.getInstance().getTimeInMillis()));
            }
        } catch (Exception e) {
            apiResponse = new ApiResponse();
            if (e.getCause() != null && e.getCause().getCause() != null &&
                    e.getCause().getCause().getMessage() != null &&
                    e.getCause().getCause().getMessage().contains(Constants.UNIQUE_CONSTRAINT_ERROR)) {
                apiResponse.setError(new ApiErrorResponse(Constants.DUPLICATE_DATA_ERROR_CODE, Constants.DUPLICATE_NAME_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
            } else {
                apiResponse.setError(new ApiErrorResponse(Constants.UNKNOWN_ERROR_CODE, Constants.UNKNOWN_ERROR_MESSAGE, Calendar.getInstance().getTimeInMillis()));
                logger.error("User registration : Failed : ", e);
            }
        }
        return apiResponse;
    }

    @Override
    public ApiSuccessResponse prepareApiOutPutData(UserAccounts userAccount) throws Exception {
        return new ApiSuccessResponse(new UserIdModel(userAccount.getId()));
    }

    @Override
    public Optional<UserAccounts> getUserByNameAndStatus(String name, boolean status) {
        return userAccountsRepository.findByNameAndStatus(name, status);
    }
}
