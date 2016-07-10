package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.Store;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wilco Wolters on 24/01/2016.
 */
@RestController
@RequestMapping("/stores")
public class StoreController extends BaseController<Store> {

}
