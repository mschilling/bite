package com.move4mobile.bite.application.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.move4mobile.bite.application.exception.BadRequestException;
import com.move4mobile.bite.application.model.BaseEntity;
import com.move4mobile.bite.application.service.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static com.move4mobile.bite.application.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
public abstract class BaseController<T extends BaseEntity<Key>, Key extends Serializable> {

    @Inject
    protected BaseService<T, Key> service;

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(BaseEntity.DefaultView.class)
    public List<T> listAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public T create(@Valid @RequestBody T t) {
        return service.create(t);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T get(@PathVariable("id") T t) {
        return notNull(t, "value");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T change(@PathVariable("id") T idProvider, @Valid @RequestBody T t) {
        if (!Objects.equals(notNull(idProvider, "id").getId(), t.getId())) {
            throw new BadRequestException("id in path and in object should be equal");
        }
        return service.modify(idProvider.getId(), t);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public T delete(@PathVariable("id") T t) {
        service.delete(notNull(t, "id"));

        return t;
    }

}
