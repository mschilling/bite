package com.move4mobile.bite.application.repository;

import com.move4mobile.bite.application.model.Store;
import com.move4mobile.bite.unscanned.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 24/01/2016.
 */
@Repository
public interface StoreRepository extends BaseRepository<Store, Long> {

    Optional<Store> findById(Long id);

}
