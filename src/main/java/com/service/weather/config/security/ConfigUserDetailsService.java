package com.service.weather.config.security;

import com.service.weather.entity.UserAccounts;
import com.service.weather.service.v1.UserAccountsService;
import com.service.weather.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "ConfigUserDetailsService")
public class ConfigUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountsService userAccountsService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<UserAccounts> userAccounts = userAccountsService.getUserByNameAndStatus(name, Constants.ACTIVE_STATUS);
        userAccounts.orElseThrow(() -> new UsernameNotFoundException("Not found: " + name));
        return userAccounts.map(ConfigUser::new).get();
    }
}
