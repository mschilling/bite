package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.Accessory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wilco Wolters on 28/07/2016.
 */
@RestController
@RequestMapping("/accessories")
public class AccessoryController extends BaseController<Accessory> {
}
