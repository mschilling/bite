package com.move4mobile.bite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Wilco Wolters on 26/01/2016.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        this(null);
    }

    public ResourceNotFoundException(String propertyName) {
        super(propertyName + " not found");
    }

}
