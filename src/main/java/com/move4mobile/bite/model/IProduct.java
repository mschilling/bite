package com.move4mobile.bite.model;

/**
 * Created by Wilco Wolters on 24/01/2016.
 */
public interface IProduct {

    String getName();
    Price getPrice();
    ProductType getType();
    Store getStore();

}
