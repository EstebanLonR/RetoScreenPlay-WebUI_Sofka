package com.co.sofka.question.signin;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.co.sofka.userinterface.automationpractice.SignInPage.VIEW_MY_CUSTOMER_ACCOUNT;

public class ViewCustomerAccount implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return Visibility.of(VIEW_MY_CUSTOMER_ACCOUNT).answeredBy(actor).booleanValue();
    }

    public static ViewCustomerAccount viewCustomerAccount() {
        return new ViewCustomerAccount();
    }
}
