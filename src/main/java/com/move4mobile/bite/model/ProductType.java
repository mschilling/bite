package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.move4mobile.bite.resolver.EntityIdResolver;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = ProductType.class)
public class ProductType extends BaseEntity {

    @Getter
    @Setter
    @javax.validation.constraints.NotNull
    private String description;

    @Getter
    @Setter
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private ProductType superType;
}
