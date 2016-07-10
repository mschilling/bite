package com.move4mobile.bite.application.controller;

import com.move4mobile.bite.application.model.Product;
import com.move4mobile.bite.application.model.Store;
import com.move4mobile.bite.application.model.StoreProduct;
import com.move4mobile.bite.application.model.requestbody.ProductPriceUpdateRequestBody;
import com.move4mobile.bite.application.service.StoreProductService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

import static com.move4mobile.bite.application.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
@RestController
@RequestMapping("/stores/{storeId}/products")
public class StoreProductController  {

    @Inject
    private StoreProductService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<StoreProduct> listAll(@PathVariable("storeId") Store store) {
        return notNull(store, "Store").getProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
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
