package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController<Order> {



}
