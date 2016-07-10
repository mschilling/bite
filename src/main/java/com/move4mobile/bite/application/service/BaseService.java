package com.move4mobile.bite.application.service;

import com.move4mobile.bite.application.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public interface BaseService<T extends BaseEntity<Key>, Key extends Serializable> {

    List<T> getAll();

    T create(T t);

    Optional<T> find(Key id);

    T modify(Key id, T t);

    void delete(T t);

}
