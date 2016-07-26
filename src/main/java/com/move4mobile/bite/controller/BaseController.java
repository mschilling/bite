package com.move4mobile.bite.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.move4mobile.bite.exception.BadRequestException;
import com.move4mobile.bite.model.BaseEntity;
import com.move4mobile.bite.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

import static com.move4mobile.bite.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
public abstract class BaseController<T extends BaseEntity> {

    @Inject
    protected BaseService<T> service;

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(BaseEntity.DefaultView.class)
    public List<T> listAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public T create(@Valid @RequestBody T t) {
        return service.store(t);
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
        return service.store(t);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public T delete(@PathVariable("id") T t) {
        service.delete(notNull(t, "id"));

        return t;
    }

}
