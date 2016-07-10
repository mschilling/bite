package com.move4mobile.bite.service;

import com.move4mobile.bite.model.Price;
import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.model.Store;
import com.move4mobile.bite.model.StoreProduct;

import java.util.List;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public interface StoreProductService {

    List<StoreProduct> getAll(Store store);

    StoreProduct create(Store store, Product product, Price price);

    StoreProduct update(Store store, Product product, Price price);

}
