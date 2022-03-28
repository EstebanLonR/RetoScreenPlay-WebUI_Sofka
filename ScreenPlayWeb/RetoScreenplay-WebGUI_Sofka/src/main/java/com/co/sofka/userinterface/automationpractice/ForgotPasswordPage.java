package com.co.sofka.userinterface.automationpractice;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ForgotPasswordPage {
    public static final Target FORGOT_PASSWORD =
            Target.the("Forgot Password").located(By.xpath("//a[@title='Recover your forgotten password']"));

    public static final Target EMAIL_RETRIEVE =
            Target.the("Email Retrieve").located(By.xpath("//input[@id='email']"));

    public static final Target RETRIEVE_PASSWORD =
            Target.the("Retrieve Password").located(By.xpath("//button[@type='submit'][contains(string(), 'Retrieve Password')]"));

    public static final Target MESSAGE_CONFIRMATION_PASSWORD =
            Target.the("Message Confirmation Password").located(By.xpath("//p[@class='alert alert-success']"));
}
