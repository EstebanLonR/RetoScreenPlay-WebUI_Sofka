package com.co.sofka.question.signin;

import com.co.sofka.userinterface.automationpractice.ForgotPasswordPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MessageRetrievePassword implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ForgotPasswordPage.MESSAGE_CONFIRMATION_PASSWORD).answeredBy(actor).trim();
    }

    public static MessageRetrievePassword messageRetrievePassword() {
        return new MessageRetrievePassword();
    }
}
