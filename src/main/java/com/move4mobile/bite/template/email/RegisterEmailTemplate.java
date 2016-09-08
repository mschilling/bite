package com.move4mobile.bite.template.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Wilco Wolters on 06/09/2016.
 */
@Configuration
@ConfigurationProperties(prefix = "template.email.register", locations = "classpath:config/template.email.properties")
public class RegisterEmailTemplate extends EmailTemplate {

}
