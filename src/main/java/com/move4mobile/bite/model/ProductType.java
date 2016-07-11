package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.*;
import com.move4mobile.bite.resolver.EntityIdResolver;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = ProductType.class)
public final class ProductType extends BaseEntity {

    @Getter
    @Setter
    @NotNull
    @JsonView(DefaultView.class)
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @JsonView(DefaultView.class)
    private ProductType superType;

    @NotNull
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Accessory> accessories = new ArrayList<>();

    @JsonIgnore
    public Collection<Accessory> getAllAccessories() {
        Collection<Accessory> accessories = getAccessories();

        ProductType type = getSuperType();
        while (type != null) {
            accessories.addAll(type.getAccessories());
        }
        return accessories;
    }

    public ArrayList<Accessory> getAccessories() {
        return new ArrayList<>(accessories);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public boolean removeAccessory(Accessory accessory) {
        return accessories.remove(accessory);
    }
}
