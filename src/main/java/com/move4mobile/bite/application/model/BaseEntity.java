package com.move4mobile.bite.application.model;

import java.io.Serializable;

/**
 * Created by Wilco Wolters on 10/07/2016.
 */
public interface BaseEntity<Key extends Serializable> {

    Key getId();

    interface DefaultView {}

}
