package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.experimental.PackagePrivate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@Entity
public class Tag {

    @PackagePrivate Tag() {}

    @JsonCreator
    public Tag(String name) {
        this.name = name;
    }

    @Id
    @Getter
    private String name;

}
