package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Wilco Wolters on 26/01/2016.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    @Getter
    @JsonView(DefaultView.class)
    private Long id;

    public interface DefaultView {}
}
