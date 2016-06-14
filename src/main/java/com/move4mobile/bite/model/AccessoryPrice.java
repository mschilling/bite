package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Named
@Entity
@EqualsAndHashCode
public class AccessoryPrice implements IProduct, Serializable {

    @Getter
    @Setter
    @NonNull
    @Id
    @ManyToOne
    private Product product;

    @Getter
    @Setter
    @NonNull
    @Id
    @ManyToOne
    private Product accessory;

    @Setter
    @Embedded
    @AttributeOverride(column = @Column(nullable = true), name = "cents")
    @Nullable
    private Price price;

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public ProductType getType() {
        return product.getType();
    }

    @Override
    public Store getStore() {
        return product.getStore();
    }

    @Override
    @Nullable
    @JsonUnwrapped
    public Price getPrice() {
        return price != null ? price : product.getPrice();
    }
}
