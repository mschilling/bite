package com.move4mobile.bite.application.repository;

import com.move4mobile.bite.application.model.BiteClientDetails;
import com.move4mobile.bite.unscanned.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 07/07/2016.
 */
@Repository
public interface ClientDetailsRepository extends BaseRepository<BiteClientDetails, Long> {

    Optional<BiteClientDetails> findByClientId(String clientId);

}
