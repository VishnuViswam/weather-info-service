package com.service.weather.model.v1;


import javax.validation.constraints.NotBlank;

/**
 * This is a custom model of user account.
 * Doesn't have any connection with database
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
public class UserModel {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public UserModel() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
