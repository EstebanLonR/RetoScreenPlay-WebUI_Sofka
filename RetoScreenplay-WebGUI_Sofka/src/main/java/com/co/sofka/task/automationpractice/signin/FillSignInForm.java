package com.co.sofka.task.automationpractice.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;

import static com.co.sofka.userinterface.automationpractice.SignInPage.*;

public class FillSignInForm implements Task {
    private String email;
    private String password;

    public FillSignInForm usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    public FillSignInForm usingThePassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL),
                SendKeys.of(email).into(EMAIL),
                Scroll.to(PASSWORD),
                SendKeys.of(password).into(PASSWORD),
                Click.on(SUBMIT_LOGGIN)
        );
    }

    public static FillSignInForm fillSignInForm() {
        return new FillSignInForm();
    }
}
