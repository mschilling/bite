package com.move4mobile.bite.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.move4mobile.bite.model.BaseEntity;
import com.move4mobile.bite.model.Store;
import com.move4mobile.bite.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.move4mobile.bite.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 24/01/2016.
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(BaseEntity.DefaultView.class)
    public List<Store> listAll() {
        return storeRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Store createStore(@Valid @RequestBody Store store) {
        return storeRepository.saveAndFlush(store);
    }

    @RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
    public Store getStore(@PathVariable("storeId") Store store) {
        return notNull(store, "Store");
    }

}
