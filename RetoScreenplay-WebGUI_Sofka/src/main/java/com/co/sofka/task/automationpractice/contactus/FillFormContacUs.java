package com.co.sofka.task.automationpractice.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;

import static com.co.sofka.userinterface.automationpractice.ContactUsPage.*;

public class FillFormContacUs implements Task {

    private String email;
    private String reference;
    private String message;

    public FillFormContacUs usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    public FillFormContacUs typeTheReference(String reference) {
        this.reference = reference;
        return this;
    }

    public FillFormContacUs typeTheMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byIndex(2).from(SUBJECT_HEADING),
                SendKeys.of(email).into(EMAIL),
                SendKeys.of(reference).into(ORDER_REFERENCE),
                SendKeys.of(message).into(MESSAGE),
                Click.on(BUTTON_SEND)
        );
    }

    public static FillFormContacUs fillFormContacUs() {
        return new FillFormContacUs();
    }
}
