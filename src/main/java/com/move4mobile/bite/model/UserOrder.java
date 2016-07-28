package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "user-order", columnNames = {"user_id", "order_id"}))
public final class UserOrder extends BaseEntity {

    public UserOrder() {
    }

    public UserOrder(User user, Order order) {
        this.order = order;
        this.user = user;
    }

    @Getter
    @NotNull
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    private User user;

    @Getter
    @NotNull
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JsonView(BaseEntity.DefaultView.class)
    private Order order;

    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    @Valid
    private List<OrderProduct> products = new ArrayList<>();

    public List<OrderProduct> getProducts() {
        return new ArrayList<>(products);
    }

    public void setProducts(List<OrderProduct> products) {
        this.products.clear();
        this.products.addAll(products);
    }
}
