package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Wilco Wolters on 05/07/2016.
 */
@Entity
public class User extends BaseEntity {

    @NotNull
    @JsonView(DefaultView.class)
    private String name;

    @Email
    @NotNull
    @JsonView(DefaultView.class)
    @Column(unique = true)
    private String email;

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
}
