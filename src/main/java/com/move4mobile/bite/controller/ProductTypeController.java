package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.ProductType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Wilco Wolters on 26/01/2016.
 */
@RestController
@RequestMapping("/product_types")
public class ProductTypeController extends BaseController<ProductType> {

}
