package com.move4mobile.bite.service.impl;

import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.repository.ProductRepository;
import com.move4mobile.bite.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    @Override
    public Optional<Product> findByName(String name) {
        return this.<ProductRepository>getRepository().findByName(name);
    }
}
