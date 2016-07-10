package com.move4mobile.bite.repository;

import com.move4mobile.bite.model.User;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 05/07/2016.
 */
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmail(String email);

}
