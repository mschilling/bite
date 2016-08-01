package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.model.Store;
import com.move4mobile.bite.model.StoreProduct;
import com.move4mobile.bite.model.requestbody.ProductPriceUpdateRequestBody;
import com.move4mobile.bite.service.StoreProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

import static com.move4mobile.bite.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@RestController
@RequestMapping("/stores/{storeId}/products")
public class StoreProductController {

    @Inject
    private StoreProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<StoreProduct> listAll(@PathVariable("storeId") Store store) {
        return notNull(store, "Store").getProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public StoreProduct create(@PathVariable("storeId") Store store, @Valid @RequestBody StoreProduct product) {
        notNull(store, "Store");
        return service.create(store, product.getProduct(), product.getPrice());
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
    public StoreProduct updatePrice(@PathVariable("storeId") Store store, @PathVariable("productId") Product product, @Valid @RequestBody ProductPriceUpdateRequestBody updateRequest) {
        notNull(store, "Store");
        notNull(product, "Product");

        return service.update(store, product, updateRequest.getPrice());
    }
}
