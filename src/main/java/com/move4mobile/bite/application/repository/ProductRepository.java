package com.move4mobile.bite.application.repository;

import com.move4mobile.bite.application.model.Product;
import com.move4mobile.bite.application.model.ProductType;
import com.move4mobile.bite.unscanned.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {

    List<Product> findByType(ProductType type);

    Optional<Product> findByName(String name);

}
