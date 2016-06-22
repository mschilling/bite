package com.move4mobile.bite.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Wilco Wolters on 22/06/2016.
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

    public ConflictException() {
        super();
    }

    public ConflictException(String message) {
        super(message);
    }

}
