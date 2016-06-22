package com.move4mobile.bite.model.requestbody;

import com.move4mobile.bite.model.Price;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class ProductPriceUpdateRequestBody {

    @NotNull
    @Getter
    private Price price;

}