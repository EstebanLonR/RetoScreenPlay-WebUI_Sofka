package com.co.sofka.task.automationpractice;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.co.sofka.userinterface.automationpractice.MainPage.CUSTOM_CARE_BUTTON;

public class GoToContactUs implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CUSTOM_CARE_BUTTON)
        );
    }

    public static GoToContactUs goToContactUs() {
        return new GoToContactUs();
    }
}
