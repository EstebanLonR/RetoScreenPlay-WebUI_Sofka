package com.co.sofka.question.createanaccount;

import com.co.sofka.userinterface.automationpractice.CreateAnAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.apache.log4j.Logger;

public class ErrorMessageEmailRegistered implements Question<String> {
    private final Logger LOGGER = Logger.getLogger(ErrorMessageEmailRegistered.class);

    @Override
    public String answeredBy(Actor actor) {
        LOGGER.info(Text.of(CreateAnAccountPage.MESSAGE_EMAIL_REGISTERED).answeredBy(actor).trim());
        return Text.of(CreateAnAccountPage.MESSAGE_EMAIL_REGISTERED).answeredBy(actor).trim();
    }

    public static ErrorMessageEmailRegistered errorMessageEmailRegistered() {
        return new ErrorMessageEmailRegistered();
    }
}
