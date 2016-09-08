package com.move4mobile.bite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wilco Wolters on 06/09/2016.
 */
@Configuration
public class TemplateConfig {

    @Bean
    public VelocityEngineFactoryBean velocityEngine() {
        VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();

        Map<String, Object> properties = new HashMap<>();
        properties.put("resource.loader", "class");
        properties.put("class.resource.loader.class", org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader.class.getName());
        factory.setVelocityPropertiesMap(properties);

        return factory;
    }

}
