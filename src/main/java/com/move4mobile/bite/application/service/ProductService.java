package com.move4mobile.bite.application.service;

import com.move4mobile.bite.application.model.Product;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public interface ProductService extends BaseService<Product, Long> {

    Optional<Product> findByName(String name);

}
