package com.move4mobile.bite.application.config;

import com.move4mobile.bite.application.exception.ResourceNotFoundException;
import com.move4mobile.bite.application.repository.ClientDetailsRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import javax.inject.Inject;

/**
 * Created by Wilco Wolters on 07/07/2016.
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Inject
    private ClientDetailsRepository clientDetailsRepository;

    @Inject
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientId -> clientDetailsRepository.findByClientId(clientId).orElseThrow(() -> new ResourceNotFoundException("Client")));
    }
}
