package com.service.weather.config.security;

import com.service.weather.entity.UserAccounts;
import com.service.weather.utility.Constants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This user class is used to map the entity user object
 * with spring security user object
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public class ConfigUser implements UserDetails {

    private String username;

    private String password;

    private boolean active;

    private List<GrantedAuthority> authorities = new ArrayList<>();


    public ConfigUser(UserAccounts userAccounts) {
        this.username = userAccounts.getName();
        this.password = userAccounts.getPassword();
        this.active = userAccounts.getStatus();
        this.authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
