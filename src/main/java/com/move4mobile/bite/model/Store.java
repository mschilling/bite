package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Named
@Entity
public class Store extends BaseEntity {

    @Getter
    @Setter
    @JsonView(WithoutProductsView.class)
    @NotNull
    private String name;

    @Getter
    @Setter
    @JsonView(WithoutProductsView.class)
    private String description;

    @Getter
    @Setter
    @ManyToMany(targetEntity = Product.class, mappedBy = "store")
    @JsonView(WithProductsView.class)
    @JsonManagedReference
    private List<Product> products;

    public interface WithoutProductsView extends DefaultView {}
    public interface WithProductsView extends WithoutProductsView {}

}
