package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.move4mobile.bite.config.Constants;
import com.move4mobile.bite.resolver.EntityIdResolver;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = Store.class)
public class Store extends BaseEntity {

    @Getter
    @Setter
    @NotNull
    @JsonView(DefaultView.class)
    @Column(length = Constants.DEFAULT_COLUMN_LENGTH)
    private String name;

    @Getter
    @Setter
    @JsonView(DefaultView.class)
    private String description;

    @OneToMany(mappedBy = "store", orphanRemoval = true, cascade = CascadeType.ALL)
    @Valid
    private List<StoreProduct> products = new ArrayList<>();

    @Getter
    @Setter
    @NotNull
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    private ProductType baseProductType;

    public List<StoreProduct> getProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(@NonNull Product product, @NonNull Price price) {
        products.add(new StoreProduct(this, product, price));
    }

    public boolean removeProduct(@NonNull Product product) {
        return products.removeIf(storeProduct -> storeProduct.getProduct().equals(product));
    }

    public interface WithoutProductsView extends DefaultView {}

}
