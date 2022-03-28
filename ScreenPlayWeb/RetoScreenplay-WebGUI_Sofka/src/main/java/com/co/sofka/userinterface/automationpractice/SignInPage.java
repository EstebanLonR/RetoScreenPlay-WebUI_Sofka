package com.co.sofka.userinterface.automationpractice;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInPage {
    public static final Target EMAIL =
            Target.the("Email").located(By.id("email"));

    public static final Target PASSWORD =
            Target.the("Password").located(By.id("passwd"));

    public static final Target SUBMIT_LOGGIN =
            Target.the("Submit Login").located(By.id("SubmitLogin"));

    public static final Target VIEW_MY_CUSTOMER_ACCOUNT =
            Target.the("View My Customer Account").located(By.xpath("//a[@title='View my customer account']"));
}
