package com.move4mobile.bite.service.impl;

import com.move4mobile.bite.exception.ConflictException;
import com.move4mobile.bite.exception.ResourceNotFoundException;
import com.move4mobile.bite.model.Price;
import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.model.Store;
import com.move4mobile.bite.model.StoreProduct;
import com.move4mobile.bite.repository.StoreProductRepository;
import com.move4mobile.bite.service.ProductService;
import com.move4mobile.bite.service.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
@Service
public class StoreProductServiceImpl implements StoreProductService {

    @Autowired
    private StoreProductRepository repository;

    @Autowired
    private ProductService productService;

    @Override
    public List<StoreProduct> getAll(Store store) {
        assert store != null;

        return store.getProducts();
    }

    @Override
    public StoreProduct create(Store store, Product product, Price price) {
        assert store != null;
        assert product != null;

        Product createdProduct = findOrCreate(product);

        if (repository.exists(new StoreProduct.Key(store, createdProduct))) {
            throw new ConflictException("This store already has this product defined.");
        }

        StoreProduct newProduct = new StoreProduct(store, createdProduct, price);
        return repository.saveAndFlush(newProduct);
    }

    @Override
    public StoreProduct update(Store store, Product product, Price price) {
        assert store != null;
        assert product != null;

        return repository.saveAndFlush(new StoreProduct(store, product, price));
    }

    private Product findOrCreate(Product product) {
        if (shouldFindById(product)) {
            return findById(product.getId());
        }

        Optional<Product> foundProduct = productService.findByName(product.getName());
        if (foundProduct.isPresent()) {
            Product existingProduct = foundProduct.get();
            preventDuplicate(product, existingProduct);
            return existingProduct;
        }

        return productService.create(product);
    }

    private Product findById(Long id) {
        return productService.find(id).orElseThrow(() -> new ResourceNotFoundException("Product"));
    }

    private boolean shouldFindById(Product product) {
        return product.getId() != null && product.getName() == null;
    }

    private void preventDuplicate(Product newProduct, Product oldProduct) {
        if (isDuplicate(newProduct, oldProduct)) {
            throw new ConflictException("A product with this name, but different type or tags already exists: " + oldProduct.getId());
        }
    }

    private boolean isDuplicate(Product newProduct, Product oldProduct) {
        return newProduct.getType().equals(oldProduct.getType()) && newProduct.getTags().equals(oldProduct.getTags());
    }
}
