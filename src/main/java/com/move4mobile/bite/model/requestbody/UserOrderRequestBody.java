package com.move4mobile.bite.model.requestbody;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.move4mobile.bite.model.Accessory;
import com.move4mobile.bite.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilco Wolters on 26/07/2016.
 */
public class UserOrderRequestBody {

    @Valid
    private List<UserOrderRequestBody.OrderProduct> products = new ArrayList<>();

    public List<UserOrderRequestBody.OrderProduct> getProducts() {
        return new ArrayList<>(products);
    }

    public void setProducts(List<UserOrderRequestBody.OrderProduct> products) {
        this.products.clear();
        this.products.addAll(products);
    }

    public static class OrderProduct {

        @NotNull
        @Getter
        @JsonIdentityReference(alwaysAsId = true)
        private Product product;

        @Getter
        @Setter
        @JsonIdentityReference(alwaysAsId = true)
        private Accessory accessory;

        @Getter
        @Setter
        @Min(1)
        private long quantity = 1;
    }

}
