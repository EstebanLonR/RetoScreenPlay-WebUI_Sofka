package com.co.sofka.question.createanaccount;

import com.co.sofka.userinterface.automationpractice.CreateAnAccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class MyAccountPage implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CreateAnAccountPage.MY_ACCOUNT_PAGE).answeredBy(actor).trim();
    }

    public static MyAccountPage myAccountPage() {
        return new MyAccountPage();
    }
}
