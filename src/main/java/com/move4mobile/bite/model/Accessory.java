package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
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
    @JsonIdentityReference(alwaysAsId = true)
    private Store store;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    @JsonIdentityReference(alwaysAsId = true)
    private Product product;

    @Getter
    @Setter
    @Embedded
    @AttributeOverride(name = "cents", column = @Column(name = "price_modification", nullable = false))
    @NotNull
    private Price priceModification;

}
