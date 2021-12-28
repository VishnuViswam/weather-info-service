package com.service.weather.entity;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Entity class
 * This class will be mapped with the database tables respectively.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-27
 */
@Entity
@Table(name = "tbl_user_account")
public class UserAccounts {

    // if our application architecture is multi tire we should implement Serializable interface in entity class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(250)")
    private String name;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(260)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(500)")
    private String password;

    @Column(name = "status", nullable = false, columnDefinition = "smallint")
    private Boolean status;

    @Column(name = "created_date", nullable = false, columnDefinition = "datetime")
    private Calendar createdDate;

    @Column(name = "created_by", nullable = false, columnDefinition = "bigint")
    private Long createdBy;

    @Column(name = "updated_date", nullable = false, columnDefinition = "datetime")
    private Calendar updatedDate;

    @Column(name = "updated_by", nullable = false, columnDefinition = "bigint")
    private Long updatedBy;

    public UserAccounts() {
        super();
    }

    public UserAccounts(String name, String email, String password, Boolean status,
                        Calendar createdDate, Long createdBy, Calendar updatedDate, Long updatedBy) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Calendar getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Calendar updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
