package com.move4mobile.bite.application;

import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.move4mobile.bite.application.resolver.EntityIdResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@SpringBootApplication
@EntityScan(basePackageClasses = {
        Application.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder(ApplicationContext applicationContext) {
        return new Jackson2ObjectMapperBuilder()
                .propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
                .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .handlerInstantiator(new SpringHandlerInstantiator(applicationContext.getAutowireCapableBeanFactory()) {
            @Override
            public ObjectIdResolver resolverIdGeneratorInstance(MapperConfig<?> config, Annotated annotated, Class<?> implClass) {
                if (implClass == EntityIdResolver.class) {
                    return new EntityIdResolver(entityManager);
                }
                return super.resolverIdGeneratorInstance(config, annotated, implClass);
            }
        });
    }

}
