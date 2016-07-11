package com.move4mobile.bite.config;

import com.move4mobile.bite.resolver.CurrentUserMethodHandlerArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Wilco Wolters on 11/07/2016.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Inject
    private CurrentUserMethodHandlerArgumentResolver currentUserResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserResolver);
    }
}
