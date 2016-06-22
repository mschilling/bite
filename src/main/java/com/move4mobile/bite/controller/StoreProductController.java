package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.Store;
import com.move4mobile.bite.model.StoreProduct;
import com.move4mobile.bite.repository.ProductRepository;
import com.move4mobile.bite.repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.move4mobile.bite.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@RestController
@RequestMapping("/stores/{storeId}/products")
public class StoreProductController {

    @Autowired
    private StoreProductRepository storeProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<StoreProduct> listAll(@PathVariable("storeId") Store store) {
        return notNull(store, "Store").getProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public StoreProduct create(@PathVariable("storeId") Store store, @Valid @RequestBody StoreProduct product) {
        notNull(store, "Store");
        StoreProduct createdProduct = new StoreProduct(store, product.getProduct(), product.getPrice());
        productRepository.save(product.getProduct());
        storeProductRepository.saveAndFlush(createdProduct);
        return createdProduct;
    }

}
