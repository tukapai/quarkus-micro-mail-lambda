package com.tukapai;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.quarkus.mailer.MockMailbox;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
class MailServiceTest {

    private static final String TO = "foo@example.com";

    @Inject
    MockMailbox mailbox;

    @Inject
    Mailer mailer;

    @BeforeEach
    void init() {
        mailbox.clear();
    }

    @Test
    void testTextMail(){

        mailer.send(
                Mail.withText(
                        TO,
                        "Alarm!",
                        "Wake up!"
                )
        );

        // verify that it was sent
        List<Mail> sent = mailbox.getMailsSentTo(TO);

        assertThat(sent).hasSize(1);
        Mail actual = sent.get(0);
        assertThat(actual.getText()).contains("Wake up!");
        assertThat(actual.getSubject()).isEqualTo("Alarm!");

    }




}