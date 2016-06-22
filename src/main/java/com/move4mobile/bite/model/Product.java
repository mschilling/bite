package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.move4mobile.bite.resolver.EntityIdResolver;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = Product.class)
public class Product extends BaseEntity {

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @ManyToOne
    @NotNull
    @JsonIdentityReference(alwaysAsId = true)
    private ProductType type;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tag> tags = new ArrayList<>();

    public List<Tag> getTags() {
        return new ArrayList<>(tags);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public boolean removeTag(Tag tag) {
        return tags.remove(tag);
    }

}
