package com.service.weather.repository;

import com.service.weather.entity.UserAccounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("UserAccountsRepository")
public interface UserAccountsRepository extends JpaRepository<UserAccounts, Long> {

    /**
     * To find the user object from db using email and status
     *
     * @param email
     * @param status
     * @return
     */
    Optional<UserAccounts> findByNameAndStatus(String email, boolean status);
}
