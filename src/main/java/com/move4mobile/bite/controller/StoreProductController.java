package com.move4mobile.bite.controller;

import com.move4mobile.bite.exception.ConflictException;
import com.move4mobile.bite.exception.ResourceNotFoundException;
import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.model.Store;
import com.move4mobile.bite.model.StoreProduct;
import com.move4mobile.bite.model.requestbody.ProductPriceUpdateRequestBody;
import com.move4mobile.bite.repository.ProductRepository;
import com.move4mobile.bite.repository.StoreProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
        final Product productToUse;
        if (product.getProduct().getId() != null && product.getProduct().getName() == null) {
            productToUse = productRepository.findOne(product.getProduct().getId());
            if (productToUse == null) {
                throw new ResourceNotFoundException("Product");
            }
        } else {
            Optional<Product> existingProduct = productRepository.findByName(product.getProduct().getName());

            if (existingProduct.isPresent()) {
                Product foundProduct = existingProduct.get();
                if (foundProduct.getType().equals(product.getProduct().getType()) && foundProduct.getTags().equals(product.getProduct().getTags())) {
                    productToUse = foundProduct;
                } else {
                    throw new ConflictException("A product with this name, but different type or tags already exists");
                }
            } else {
                productToUse = productRepository.save(product.getProduct());
            }
        }

        if (storeProductRepository.exists(new StoreProduct.Key(store, productToUse))) {
            throw new ConflictException("This store already has this product defined.");
        }

        StoreProduct createdProduct = new StoreProduct(store, productToUse, product.getPrice());
        storeProductRepository.saveAndFlush(createdProduct);
        return createdProduct;
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    public StoreProduct updatePrice(@PathVariable("storeId") Store store, @PathVariable("productId") Product product, @Valid @RequestBody ProductPriceUpdateRequestBody updateRequest) {
        notNull(store, "Store");
        notNull(product, "Product");

        return storeProductRepository.saveAndFlush(new StoreProduct(store, product, updateRequest.getPrice()));
    }
}
