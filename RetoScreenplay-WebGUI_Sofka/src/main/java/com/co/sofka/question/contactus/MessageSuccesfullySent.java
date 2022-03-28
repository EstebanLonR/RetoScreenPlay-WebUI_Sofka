package com.co.sofka.question.contactus;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.co.sofka.userinterface.automationpractice.ContactUsPage.MESSAGE_SENT_ASSERTION;

public class MessageSuccesfullySent implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Visibility.of(MESSAGE_SENT_ASSERTION).answeredBy(actor).booleanValue();
    }

    public static MessageSuccesfullySent messageSuccesfullySentMessage() {
        return new MessageSuccesfullySent();
    }
}
