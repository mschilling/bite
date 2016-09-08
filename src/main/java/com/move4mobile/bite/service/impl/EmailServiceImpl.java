package com.move4mobile.bite.service.impl;

import com.move4mobile.bite.email.TemplateMessageHelper;
import com.move4mobile.bite.service.EmailService;
import com.move4mobile.bite.template.email.RegisterEmailTemplate;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Wilco Wolters on 06/09/2016.
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Inject
    private VelocityEngine velocityEngine;

    @Inject
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailPreparator preparator) {
        mailSender.send(mimeMessage -> {
            TemplateMessageHelper message = new TemplateMessageHelper(mimeMessage, velocityEngine);
            preparator.prepare(message);
        });
    }

}
