package com.move4mobile.bite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@Entity
public class Accessory extends BaseEntity {

    @Getter
    @Setter
    @ManyToOne
    private Store store;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    private Product product;

    @Getter
    @Setter
    @Embedded
    @AttributeOverride(name = "cents", column = @Column(name = "price_modification", nullable = false))
    @NotNull
    private Price priceModification;

}
