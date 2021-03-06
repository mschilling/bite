package com.move4mobile.bite.model;

import com.move4mobile.bite.config.Constants;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.Duration;
import java.util.*;

/**
 * Created by Wilco Wolters on 07/07/2016.
 */
@Entity
public class BiteClientDetails extends BaseEntity implements ClientDetails {

    @Column(unique = true, nullable = false, length = Constants.DEFAULT_COLUMN_LENGTH)
    @Getter
    private String clientId;

    @Getter
    @Column(nullable = false, length = Constants.DEFAULT_COLUMN_LENGTH)
    private String clientSecret;

    @Getter
    private Duration accessTokenValidity;

    @Getter
    private Duration refreshTokenValidity;

    @Column(nullable = false)
    private String scope;

    private static final Set<String> grantTypes = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("password", "refresh_token")));

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public boolean isScoped() {
        return true;
    }

    @Override
    public Set<String> getScope() {
        return Collections.singleton(scope);
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return grantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return Collections.emptySet();
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity != null ? (int)accessTokenValidity.getSeconds() : null;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity != null ?  (int)refreshTokenValidity.getSeconds() : null;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
