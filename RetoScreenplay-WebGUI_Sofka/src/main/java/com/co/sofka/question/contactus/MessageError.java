package com.co.sofka.question.contactus;

import com.co.sofka.userinterface.automationpractice.ContactUsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MessageError implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ContactUsPage.MESSAGE_ERROR_MESSAGE).answeredBy(actor).trim();
    }

    public static MessageError messageError() {
        return new MessageError();
    }
}
