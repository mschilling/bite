package com.move4mobile.bite.repository;

import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.model.ProductType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Repository
public interface ProductRepository extends BaseRepository<Product> {

    List<Product> findByType(ProductType type);

}
