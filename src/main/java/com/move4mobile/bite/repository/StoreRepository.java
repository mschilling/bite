package com.move4mobile.bite.repository;

import com.move4mobile.bite.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 24/01/2016.
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findById(Long id);

}
