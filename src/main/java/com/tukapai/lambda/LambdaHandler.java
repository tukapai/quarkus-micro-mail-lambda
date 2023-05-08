package com.tukapai.lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import com.amazonaws.services.lambda.runtime.Context;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Map;

@Named("main")
@ApplicationScoped
public class LambdaHandler implements RequestHandler<Map<String,String>, String> {

    @Inject
    Mailer mailer;

    @Override
    public String handleRequest(Map<String,String> input, Context context) {
        MailContents contents = new MailContents(input);
        mailer.send(contents.getMail());
        return "200 OK";
    }

}



