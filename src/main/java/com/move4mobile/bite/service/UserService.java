package com.move4mobile.bite.service;

import com.move4mobile.bite.model.User;

import java.util.Optional;

public interface UserService extends BaseService<User> {

    Optional<User> findByEmail(String email);

}
