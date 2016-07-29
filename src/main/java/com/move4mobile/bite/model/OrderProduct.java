package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.move4mobile.bite.validation.constraints.AllowedAccessory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "`order-product-accessory`", columnNames = {"order_id", "product_id", "accessory_id"}))
@AllowedAccessory
public final class OrderProduct extends BaseEntity {

    public OrderProduct() {
    }

    public OrderProduct(UserOrder order, Product product, Accessory accessory, long quantity) {
        this.order = order;
        this.product = product;
        this.accessory = accessory;
        this.quantity = quantity;
    }

    @ManyToOne
    @NotNull
    @JsonIgnore
    @Getter
    @Setter
    private UserOrder order;

    @ManyToOne
    @NotNull
    @Getter
    @JsonIdentityReference(alwaysAsId = true)
    private Product product;

    @Getter
    @Setter
    @ManyToOne
    private Accessory accessory;

    @Getter
    @Setter
    @Min(1)
    private long quantity = 1;
}
