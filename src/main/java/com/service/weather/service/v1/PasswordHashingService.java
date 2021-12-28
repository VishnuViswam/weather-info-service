package com.service.weather.service.v1;


public interface PasswordHashingService {
    /**
     * To encrypt password
     *
     * @param rawPassword
     * @return
     */
    String encode(CharSequence rawPassword);

    /**
     * To verify the encrypted password
     *
     * @param rawPassword
     * @param encodedPassword
     * @return
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);

}
