package com.move4mobile.bite.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.move4mobile.bite.model.BaseEntity;
import com.move4mobile.bite.model.User;
import com.move4mobile.bite.model.requestbody.ChangePasswordRequestBody;
import com.move4mobile.bite.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Wilco Wolters on 18/07/2016.
 */
@RestController
@RequestMapping
public class AccountController {

    @Inject
    private UserService userService;

    @Inject
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(BaseEntity.DefaultView.class)
    public User register(@Valid @JsonView(User.RegisterView.class) @RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userService.registerUser(user, true);
    }

    @RequestMapping(value = "/password", method = RequestMethod.PUT)
    public User changePassword(@Valid @RequestBody ChangePasswordRequestBody changeRequest, User currentUser) {
        currentUser.setPassword(passwordEncoder.encode(changeRequest.getPassword()));

        return userService.store(currentUser);
    }

}
