package com.move4mobile.bite.repository;

import com.move4mobile.bite.model.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
public interface StoreProductRepository extends JpaRepository<StoreProduct, StoreProduct.Key> {
}
