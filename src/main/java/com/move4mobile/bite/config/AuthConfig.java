package com.move4mobile.bite.config;

import com.move4mobile.bite.exception.ResourceNotFoundException;
import com.move4mobile.bite.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;

/**
 * Created by Wilco Wolters on 07/07/2016.
 */
@Configuration
public class AuthConfig extends GlobalAuthenticationConfigurerAdapter {

    @Inject
    UserService userService;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
    }

    @Bean
    UserDetailsService userDetailsService() {
        return username -> userService.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
