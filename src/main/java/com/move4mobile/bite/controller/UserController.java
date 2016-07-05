package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wilco Wolters on 05/07/2016.
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController<User> {
}
