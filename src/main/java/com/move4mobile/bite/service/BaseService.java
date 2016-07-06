package com.move4mobile.bite.service;

import com.move4mobile.bite.model.BaseEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public interface BaseService<T extends BaseEntity> {

    List<T> getAll();

    T create(T t);

    Optional<T> find(long id);

    T modify(Long id, T t);

    void delete(T t);

}
