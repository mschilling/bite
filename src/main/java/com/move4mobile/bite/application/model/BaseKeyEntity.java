package com.move4mobile.bite.application.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by Wilco Wolters on 26/01/2016.
 */
@MappedSuperclass
public abstract class BaseKeyEntity<Key extends Serializable> implements BaseEntity<Key> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @JsonView(DefaultView.class)
    private Key id;
}
