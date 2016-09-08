package com.move4mobile.bite.email;

import com.move4mobile.bite.template.email.EmailTemplate;
import org.apache.velocity.app.VelocityEngine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.Map;

/**
 * Created by Wilco Wolters on 06/09/2016.
 */
public class TemplateMessageHelper extends MimeMessageHelper {

    private final VelocityEngine velocityEngine;

    public TemplateMessageHelper(MimeMessage mimeMessage, @NotNull VelocityEngine velocityEngine) throws MessagingException {
        super(mimeMessage, true, "UTF-8");
        this.velocityEngine = velocityEngine;
    }

    @Override
    public void setSubject(String subject) throws MessagingException {
        subject = subject.replace('\n', ' ').replace('\r', ' ');
        super.setSubject(subject);
    }

    public void setTextFromTemplate(String templateLocation, Map<String, Object> model) throws MessagingException {
        String resolvedTemplate = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation, "UTF-8", model);
        setText(resolvedTemplate, true);
    }

    public void applyTemplate(EmailTemplate template, @Nullable Map<String, Object> model) throws MessagingException {
        if (model == null) {
            model = Collections.emptyMap();
        }

        setSubject(template.getSubject());

        String body = template.getBody();
        if (body != null) {
            setText(body, true);
        } else {
            String templateLocation = template.getTemplatePath();
            if (templateLocation == null) {
                throw new IllegalArgumentException("Neither template path nor body is supplied");
            }
            setTextFromTemplate(templateLocation, model);
        }
    }
}
