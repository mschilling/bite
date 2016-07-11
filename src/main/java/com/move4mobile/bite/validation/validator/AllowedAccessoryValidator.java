package com.move4mobile.bite.validation.validator;

import com.move4mobile.bite.model.Accessory;
import com.move4mobile.bite.model.OrderProduct;
import com.move4mobile.bite.model.Product;
import com.move4mobile.bite.validation.constraints.AllowedAccessory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

/**
 * Created by Wilco Wolters on 11/07/2016.
 */
public class AllowedAccessoryValidator implements ConstraintValidator<AllowedAccessory, OrderProduct> {
    @Override
    public void initialize(AllowedAccessory constraintAnnotation) {

    }

    @Override
    public boolean isValid(OrderProduct value, ConstraintValidatorContext context) {
        return hasLegalAccessory(value);
    }

    private static boolean hasLegalAccessory(OrderProduct product) {
        if (product.getAccessory() == null) {
            return true;
        }

        Product accessoryProduct = product.getAccessory();
        return collectionContains(product.getProduct().getType().getAllAccessories(), accessoryProduct);
    }

    private static boolean collectionContains(Collection<Accessory> accessories, Product product) {
        return accessories.stream()
                .anyMatch(accessory -> accessory.getProduct().equals(product));
    }
}
