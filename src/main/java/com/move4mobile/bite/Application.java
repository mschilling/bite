package com.move4mobile.bite;

import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.google.common.base.Predicates;
import com.move4mobile.bite.resolver.EntityIdResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.SpringHandlerInstantiator;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * Created by Wilco Wolters on 23/01/2016.
 */
@SpringBootApplication
@EnableSwagger2
@EntityScan(basePackageClasses = {
        Application.class,
        Jsr310Converters.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private TypeResolver typeResolver;

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public Docket biteApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo("Bite API", "Describes the Move4Mobile Bite API", "1.0", null, (Contact)null, null, null))
                .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(Predicates.not(PathSelectors.regex("/error")))
                    .build()
                //.directModelSubstitute(LocalDate.class, String.class)
                //.genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)));

    }

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder(ApplicationContext applicationContext) {
        return new Jackson2ObjectMapperBuilder()
                .propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES)
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
