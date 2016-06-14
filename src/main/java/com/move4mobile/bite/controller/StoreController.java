package com.move4mobile.bite.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.move4mobile.bite.exception.ResourceNotFoundException;
import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.model.Store;
import com.move4mobile.bite.repository.ProductRepository;
import com.move4mobile.bite.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 24/01/2016.
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(Store.WithoutProductsView.class)
    public List<Store> listAll() {
        return storeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @JsonView(Store.WithoutProductsView.class)
    public Store createStore(@Valid @RequestBody @JsonView(Store.WithoutProductsView.class) Store store) {
        return storeRepository.saveAndFlush(store);
    }

    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    @JsonView(Store.WithProductsView.class)
    public Store getStore(@PathVariable("storeId") Optional<Store> store) {
        return store.orElseThrow(() -> new ResourceNotFoundException("Store not found"));
    }

    @RequestMapping(value = "/{storeId}/products", method = RequestMethod.GET)
    public List<Product> productsFromStore(@PathVariable("storeId") Optional<Store> store) {
        return getStore(store).getProducts();
    }

    @RequestMapping(value = "/{storeId}/products", method = RequestMethod.POST)
    public Product createProduct(@PathVariable("storeId") Optional<Store> store, @Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    /*@RequestMapping(value ="/{storeId}/products", method = RequestMethod.POST)
    public Product addProduct()*/

}
