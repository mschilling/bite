package com.move4mobile.bite.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.move4mobile.bite.model.BaseEntity;
import com.move4mobile.bite.repository.BaseRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;

import static com.move4mobile.bite.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
public class BaseController<T extends BaseEntity> {

    @Inject
    protected BaseRepository<T> repository;

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(BaseEntity.DefaultView.class)
    public List<T> listAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public T create(@Valid @RequestBody T t) {
        return repository.saveAndFlush(t);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable("id") T t) {
        return notNull(t, "value");
    }

}
