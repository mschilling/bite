package com.move4mobile.bite.support;

import com.move4mobile.bite.exception.ResourceNotFoundException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by Wilco Wolters on 21/06/2016.
 */
public class Validate {

    @Contract("null, _ -> fail")
    @NotNull
    public static <T> T notNull(@Nullable T object, @NotNull String name) {
        if (object == null) {
            throw new ResourceNotFoundException(name);
        }
        return object;
    }

}
