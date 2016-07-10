package com.move4mobile.bite.application.service;

import com.move4mobile.bite.application.model.Price;
import com.move4mobile.bite.application.model.Product;
import com.move4mobile.bite.application.model.Store;
import com.move4mobile.bite.application.model.StoreProduct;

import java.util.List;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public interface StoreProductService extends BaseService<StoreProduct, StoreProduct.Key> {

    List<StoreProduct> getAll(Store store);

    StoreProduct create(Store store, Product product, Price price);

    StoreProduct update(Store store, Product product, Price price);

}
