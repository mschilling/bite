package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.ProductType;
import com.move4mobile.bite.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Wilco Wolters on 26/01/2016.
 */
@RestController
@RequestMapping("/products/types")
public class ProductTypeController {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductType> listAll() {
        return productTypeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductType createProductType(@Valid @RequestBody ProductType productType) {
        return productTypeRepository.save(productType);
    }

}
