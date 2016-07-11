package com.move4mobile.bite.validation.constraints;

import com.move4mobile.bite.validation.validator.AllowedAccessoryValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Wilco Wolters on 11/07/2016.
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = AllowedAccessoryValidator.class)
@Documented
public @interface AllowedAccessory {

    String message() default "{com.move4mobile.bite.validation.constraints.AllowedAccessory.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
