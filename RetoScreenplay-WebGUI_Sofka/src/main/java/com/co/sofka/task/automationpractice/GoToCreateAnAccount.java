package com.co.sofka.task.automationpractice;

import com.co.sofka.userinterface.automationpractice.MainPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.co.sofka.userinterface.automationpractice.MainPage.SING_IN_BUTTON;

public class GoToCreateAnAccount implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SING_IN_BUTTON)
        );
    }

    public static GoToCreateAnAccount goToCreateAnAccount() {
        return new GoToCreateAnAccount();
    }
}
