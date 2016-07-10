package com.move4mobile.bite.application.service.impl;

import com.move4mobile.bite.application.model.BaseEntity;
import com.move4mobile.bite.unscanned.repository.BaseRepository;
import com.move4mobile.bite.application.service.BaseService;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public abstract class BaseServiceImpl<T extends BaseEntity<Key>, Key extends Serializable> implements BaseService<T, Key> {

    @Inject
    protected BaseRepository<T, Key> repository;

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T create(T t) {
        return repository.saveAndFlush(t);
    }

    @Override
    public Optional<T> find(Key id) {
        return Optional.of(repository.findOne(id));
    }

    @Override
    public T modify(Key id, T t) {
        assert Objects.equals(id, t.getId());

        return repository.saveAndFlush(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    protected <R extends BaseRepository<T, Key>> R getRepository() {
        //noinspection unchecked
        return (R) repository;
    }
}
