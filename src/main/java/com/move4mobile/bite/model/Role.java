package com.move4mobile.bite.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Wilco Wolters on 07/07/2016.
 */
public enum Role implements GrantedAuthority {
    ADMIN,
    USER;

    @Override
    public String getAuthority() {
        return toString();
    }
}
