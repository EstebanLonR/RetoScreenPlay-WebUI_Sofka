package com.co.sofka.task.automationpractice.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;

import static com.co.sofka.userinterface.automationpractice.ContactUsPage.*;

public class FillFormContacUsWithoutMessage implements Task {
    private String email;
    private String reference;

    public FillFormContacUsWithoutMessage usingTheEmail(String email) {
        this.email = email;
        return this;
    }

    public FillFormContacUsWithoutMessage typeTheReference(String reference) {
        this.reference = reference;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SelectFromOptions.byIndex(2).from(SUBJECT_HEADING),
                SendKeys.of(email).into(EMAIL),
                SendKeys.of(reference).into(ORDER_REFERENCE),
                Click.on(BUTTON_SEND)
        );
    }

    public static FillFormContacUsWithoutMessage fillFormContacUsWithoutMessage() {
        return new FillFormContacUsWithoutMessage();
    }
}
