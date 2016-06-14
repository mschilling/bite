package com.move4mobile.bite.repository;

import com.move4mobile.bite.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Wilco Wolters on 26/01/2016.
 */
@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
