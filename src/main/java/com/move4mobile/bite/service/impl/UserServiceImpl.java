package com.move4mobile.bite.service.impl;

import com.move4mobile.bite.exception.BadRequestException;
import com.move4mobile.bite.model.User;
import com.move4mobile.bite.repository.UserRepository;
import com.move4mobile.bite.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User store(User user) {
        if (findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("User already exists");
        }

        return super.store(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return this.<UserRepository>getRepository().findByEmail(email);
    }
}
