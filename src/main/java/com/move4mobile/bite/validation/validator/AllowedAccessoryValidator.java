package com.move4mobile.bite.validation.validator;

import com.move4mobile.bite.model.Accessory;
import com.move4mobile.bite.model.OrderProduct;
import com.move4mobile.bite.validation.constraints.AllowedAccessory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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

        Accessory accessory = product.getAccessory();
        return product.getProduct().getType().getAllAccessories().contains(accessory);
    }

}
