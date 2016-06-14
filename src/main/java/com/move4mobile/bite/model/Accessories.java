package com.move4mobile.bite.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by Wilco Wolters on 30/01/2016.
 */

@Embeddable
@Entity
public class Accessories {

    @Getter
    @Setter
    @ManyToMany
    private List<ProductType> productTypes;

    @Getter
    @Setter
    @ManyToMany
    private List<AccessoryPrice> products;

}
