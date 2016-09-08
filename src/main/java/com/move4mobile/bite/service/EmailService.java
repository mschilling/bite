package com.move4mobile.bite.service;

import com.move4mobile.bite.email.TemplateMessageHelper;

/**
 * Created by Wilco Wolters on 06/09/2016.
 */
public interface EmailService {

    void sendEmail(EmailPreparator preparator);

    interface EmailPreparator {

        void prepare(TemplateMessageHelper message) throws Exception;

    }
}
