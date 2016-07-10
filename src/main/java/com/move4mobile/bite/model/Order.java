package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilco Wolters on 04/07/2016.
 */
@Entity
@Table(name = "\"order\"")
public class Order extends BaseEntity {

    @ManyToOne
    @JsonIdentityReference(alwaysAsId = true)
    @NotNull
    @Getter
    @Setter
    @JsonView(DefaultView.class)
    private Store store;

    @Getter
    @Setter
    @NotNull
    @JsonView(DefaultView.class)
    private OffsetDateTime openDate;

    @Getter
    @Setter
    @Nullable
    @JsonView(DefaultView.class)
    private OffsetDateTime closeDate;

    @Getter
    @Setter
    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<UserOrder> userOrders = new ArrayList<>();
}
