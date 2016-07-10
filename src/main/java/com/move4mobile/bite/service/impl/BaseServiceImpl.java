package com.move4mobile.bite.service.impl;

import com.move4mobile.bite.model.BaseEntity;
import com.move4mobile.bite.repository.BaseRepository;
import com.move4mobile.bite.service.BaseService;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 06/07/2016.
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    @Inject
    protected BaseRepository<T> repository;

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T create(T t) {
        return repository.saveAndFlush(t);
    }

    @Override
    public Optional<T> find(Long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    public T modify(Long id, T t) {
        assert Objects.equals(id, t.getId());

        return repository.saveAndFlush(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    protected <R extends BaseRepository<T>> R getRepository() {
        //noinspection unchecked
        return (R) repository;
    }
}
