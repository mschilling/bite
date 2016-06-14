package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.experimental.PackagePrivate;

import javax.inject.Named;
import javax.persistence.Embeddable;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Named
@Embeddable
public class Price {

    @PackagePrivate Price() {}

    @JsonCreator
    public Price(long cents) {
        this.cents = cents;
    }

    private long cents;

    @JsonValue
    public long getCents() {
        return cents;
    }

}
