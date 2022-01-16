package com.service.weather.serviceImpl.v1;

import com.service.weather.entity.UserAccounts;
import com.service.weather.model.v1.*;
import com.service.weather.repository.UserAccountsRepository;
import com.service.weather.service.v1.PasswordHashingService;
import com.service.weather.service.v1.UserAccountsService;
import com.service.weather.service.v1.ValidationService;
import com.service.weather.utility.Constants;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
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

    private static final Logger logger = LoggerFactory.getLogger(UserAccountsServiceImpl.class);

    @Autowired
    private UserAccountsRepository userAccountsRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private PasswordHashingService passwordHashingService;

    @Override
    public ApiSuccessResponse userRegistration(UserModel userModel) {
        ApiSuccessResponse apiSuccessResponse = null;
        UserAccounts userAccounts = null;
        String password = null;
        try {
            password = passwordHashingService.encode(userModel.getPassword());
            userAccounts = new UserAccounts(userModel.getName(), userModel.getEmail(), password, Constants.ACTIVE_STATUS,
                    Calendar.getInstance(), Constants.DEFAULT_USER_ACCOUNT_ID, Calendar.getInstance(), Constants.DEFAULT_USER_ACCOUNT_ID);
            userAccountsRepository.save(userAccounts);
            apiSuccessResponse = new ApiSuccessResponse();
            apiSuccessResponse.setData(new UserIdModel(userAccounts.getId()));
        } catch (DataIntegrityViolationException e) {
            apiSuccessResponse = new ApiSuccessResponse();
            if (e.getCause() != null && e.getCause().getCause() != null &&
                    e.getCause().getCause().getMessage() != null &&
                    e.getCause().getCause().getMessage().contains(Constants.UNIQUE_CONSTRAINT_ERROR)) {
                throw new DataIntegrityViolationException(String.valueOf(Constants.UNIQUE_NAME_ERROR_CODE));
            }
        }
        return apiSuccessResponse;
    }

    @Override
    public Optional<UserAccounts> getUserByNameAndStatus(String name, boolean status) {
        return userAccountsRepository.findByNameAndStatus(name, status);
    }
}
