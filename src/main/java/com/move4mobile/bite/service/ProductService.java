package com.move4mobile.bite.service;

import com.move4mobile.bite.model.Product;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public interface ProductService extends BaseService<Product> {

    Optional<Product> findByName(String name);

}
