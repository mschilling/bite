package com.move4mobile.bite.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@Entity
@IdClass(Accessory.Key.class)
public final class Accessory implements BaseEntity<Accessory.Key> {

    @Getter
    @Setter
    @ManyToOne
    @Id
    private Store store;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    @Id
    private Product product;

    @Getter
    @Setter
    @Embedded
    @AttributeOverride(name = "cents", column = @Column(name = "price_modification", nullable = false))
    @NotNull
    private Price priceModification;

    @Override
    @JsonIgnore
    public Key getId() {
        return new Key(store, product);
    }

    public static class Key implements Serializable {
        private Long store;
        private Long product;

        public Key() {
        }
        public Key(Store store, Product product) {
            this.store = store.getId();
            this.product = product.getId();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (store != null ? !store.equals(key.store) : key.store != null) return false;
            return product != null ? product.equals(key.product) : key.product == null;

        }

        @Override
        public int hashCode() {
            int result = store != null ? store.hashCode() : 0;
            result = 31 * result + (product != null ? product.hashCode() : 0);
            return result;
        }
    }

}
