package com.co.sofka.task.automationpractice.signin;

import com.co.sofka.userinterface.automationpractice.ForgotPasswordPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

import static com.co.sofka.userinterface.automationpractice.ForgotPasswordPage.*;

public class RecoverYourPassword implements Task {
    private String email;

    public RecoverYourPassword usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FORGOT_PASSWORD),
                SendKeys.of(email).into(EMAIL_RETRIEVE),
                Click.on(RETRIEVE_PASSWORD)
        );
    }

    public static RecoverYourPassword recoverYourPassword() {
        return new RecoverYourPassword();
    }
}
