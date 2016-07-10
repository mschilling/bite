package com.move4mobile.bite.application.repository;

import com.move4mobile.bite.application.model.ProductType;
import com.move4mobile.bite.unscanned.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Wilco Wolters on 26/01/2016.
 */
@Repository
public interface ProductTypeRepository extends BaseRepository<ProductType, Long> {
}
