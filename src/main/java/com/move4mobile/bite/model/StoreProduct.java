package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@Entity
@IdClass(StoreProduct.Key.class)
public class StoreProduct {

    public StoreProduct() {
    }

    public StoreProduct(Store store, Product product, Price price) {
        this.store = store;
        this.product = product;
        this.price = price;
    }

    @ManyToOne
    @JsonIgnore
    @Id
    private Store store;

    @Getter
    @ManyToOne
    @JsonUnwrapped
    @JsonIdentityReference
    @Id
    private Product product;

    @Getter
    @Setter
    @NotNull
    private Price price;

    @JsonProperty
    @JsonIdentityReference(alwaysAsId = true)
    public Store getStore() {
        return store;
    }

    public static class Key implements Serializable {
        private Long store;
        private Long product;

        public Key() {}
        public Key(Store store, Product product) {
            this.store = store.getId();
            this.product = product.getId();
        }
    }
}
