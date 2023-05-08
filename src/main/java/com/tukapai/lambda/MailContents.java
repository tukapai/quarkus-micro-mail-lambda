package com.tukapai.lambda;

import io.quarkus.mailer.Mail;

import java.util.Map;

public class MailContents {

    public MailContents(Map<String, String> input) {
        this.to = input.get("to");
        this.subject = input.get("subject");
        this.text = input.get("text");
    }
    private final String to;
    private final String subject;
    private final String text;
    public Mail getMail(){
        return Mail.withText(to, subject, text);
    }
}
