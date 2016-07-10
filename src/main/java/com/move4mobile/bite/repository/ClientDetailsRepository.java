package com.move4mobile.bite.repository;

import com.move4mobile.bite.model.BiteClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 07/07/2016.
 */
@Repository
public interface ClientDetailsRepository extends JpaRepository<BiteClientDetails, Long> {

    Optional<BiteClientDetails> findByClientId(String clientId);

}
