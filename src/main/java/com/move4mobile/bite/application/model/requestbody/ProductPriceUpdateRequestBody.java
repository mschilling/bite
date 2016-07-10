package com.move4mobile.bite.application.model.requestbody;

import com.move4mobile.bite.application.model.Price;
import lombok.Getter;

import javax.validation.constraints.NotNull;

public class ProductPriceUpdateRequestBody {

    @NotNull
    @Getter
    private Price price;

}