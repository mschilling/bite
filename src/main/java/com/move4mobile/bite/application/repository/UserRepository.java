package com.move4mobile.bite.application.repository;

import com.move4mobile.bite.application.model.User;
import com.move4mobile.bite.unscanned.repository.BaseRepository;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 05/07/2016.
 */
public interface UserRepository extends BaseRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
