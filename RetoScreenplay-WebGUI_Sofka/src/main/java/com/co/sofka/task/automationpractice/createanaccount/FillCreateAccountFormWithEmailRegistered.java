package com.co.sofka.task.automationpractice.createanaccount;

import com.co.sofka.userinterface.automationpractice.CreateAnAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;

import static com.co.sofka.userinterface.automationpractice.CreateAnAccountPage.EMAIL_CREATE;
import static com.co.sofka.userinterface.automationpractice.CreateAnAccountPage.SUBMIT_CREATE;

public class FillCreateAccountFormWithEmailRegistered implements Task {
    private String email;

    public FillCreateAccountFormWithEmailRegistered usingEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(email).into(EMAIL_CREATE),
                Scroll.to(SUBMIT_CREATE),
                Click.on(SUBMIT_CREATE)
        );

    }

    public static FillCreateAccountFormWithEmailRegistered fillCreateAccountFormWithEmailRegistered() {
        return new FillCreateAccountFormWithEmailRegistered();
    }
}
