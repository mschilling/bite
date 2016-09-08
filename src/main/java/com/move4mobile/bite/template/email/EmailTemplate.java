package com.move4mobile.bite.template.email;

/**
 * Created by Wilco Wolters on 06/09/2016.
 */
public class EmailTemplate {

    private String subject;
    private String body;
    private String templatePath;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public String getTemplatePath() {
        return templatePath;
    }
}
