package com.move4mobile.bite.application.controller;

import com.move4mobile.bite.application.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wilco Wolters on 05/07/2016.
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController<User, Long> {
}
