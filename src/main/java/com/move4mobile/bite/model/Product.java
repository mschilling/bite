package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Entity
public class Product extends BaseEntity implements IProduct {

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @Embedded
    private Accessories accessories;

    @Getter
    @Setter
    private Price price;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    private ProductType type;

    @Getter
    @Setter
    @ManyToMany
    @JsonBackReference
    private Store store;
}
