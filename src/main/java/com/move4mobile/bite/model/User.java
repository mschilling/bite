package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Wilco Wolters on 05/07/2016.
 */
@Entity
public class User extends BaseEntity {

    @NotNull
    @JsonView(DefaultView.class)
    @Getter
    @Setter
    private String name;

    @Email
    @NotNull
    @JsonView(DefaultView.class)
    @Column(unique = true)
    @Getter
    @Setter
    private String email;

    @NotNull
    private String password;

    @Getter
    @Setter
    @JsonIgnore
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles")
    @Column(name = "role")
    private Set<Role> roles;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
