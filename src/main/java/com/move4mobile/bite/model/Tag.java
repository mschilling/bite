package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.experimental.PackagePrivate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@Entity
public class Tag {

    @PackagePrivate Tag() {}

    @JsonCreator
    public Tag(@NotNull String name) {
        this.name = name;
    }

    @Id
    @NotNull
    @Column(length = 60)
    @Size(max = 60)
    private String name;

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return name.equals(tag.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
