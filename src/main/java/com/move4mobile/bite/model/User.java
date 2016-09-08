package com.move4mobile.bite.model;

import com.fasterxml.jackson.annotation.*;
import com.move4mobile.bite.config.Constants;
import com.move4mobile.bite.resolver.EntityIdResolver;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Wilco Wolters on 05/07/2016.
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", resolver = EntityIdResolver.class, scope = User.class)
public final class User extends BaseEntity implements UserDetails {

    @NotNull
    @JsonView(DefaultView.class)
    @Getter
    @Setter
    @Column(length = Constants.DEFAULT_COLUMN_LENGTH)
    private String name;

    @Email
    @NotNull
    @JsonView(DefaultView.class)
    @Column(unique = true, length = 100)
    @Getter
    @Setter
    private String email;

    @NotNull
    @Getter
    @Setter
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonView(RegisterView.class)
    private String password;

    @Getter
    @Setter
    @JsonIgnore
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "User_Roles")
    @Column(name = "role")
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<UserOrder> orders;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return getEmail();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public interface RegisterView extends DefaultView {}
}
