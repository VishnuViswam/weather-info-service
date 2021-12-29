package com.service.weather.security;

import com.service.weather.entity.UserAccounts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
