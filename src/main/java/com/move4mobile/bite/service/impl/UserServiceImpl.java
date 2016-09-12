package com.move4mobile.bite.service.impl;

import com.move4mobile.bite.exception.BadRequestException;
import com.move4mobile.bite.model.User;
import com.move4mobile.bite.repository.UserRepository;
import com.move4mobile.bite.service.EmailService;
import com.move4mobile.bite.service.UserService;
import com.move4mobile.bite.template.email.RegisterEmailTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Inject
    private EmailService emailService;

    @Inject
    private RegisterEmailTemplate registerTemplate;

    @Override
    public Optional<User> findByEmail(String email) {
        return this.<UserRepository>getRepository().findByEmail(email);
    }

    @Override
    public User registerUser(User user, boolean sendEmail) {
        if (findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("User already exists");
        }

        User registeredUser = store(user);

        if (sendEmail) {
            emailService.sendEmail(message -> {
                message.setTo(registeredUser.getEmail());
                Map<String, Object> model = new HashMap<>();
                model.put("user", registeredUser);
                message.applyTemplate(registerTemplate, model);
            });
        }

        return registeredUser;
    }
}
