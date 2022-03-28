package com.co.sofka.userinterface.automationpractice;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAnAccountPage {
    public static final Target EMAIL_CREATE =
            Target.the("Email Create").located(By.id("email_create"));

    public static final Target SUBMIT_CREATE =
            Target.the("Submit Create").located(By.id("SubmitCreate"));

    public static final Target TITLE_MALE =
            Target.the("Title").located(By.xpath("//input[@id='id_gender1']"));

    public static final Target TITLE_FEMALE =
            Target.the("Title").located(By.xpath("//input[@id='id_gender2']"));

    public static final Target FIRST_NAME =
            Target.the("First Name").located(By.id("customer_firstname"));

    public static final Target LAST_NAME =
            Target.the("Last Name").located(By.id("customer_lastname"));

    public static final Target PASSWORD =
            Target.the("Password").located(By.id("passwd"));

    public static final Target ADDRESS =
            Target.the("Address").located(By.id("address1"));

    public static final Target CITY =
            Target.the("City").located(By.id("city"));

    public static final Target STATE =
            Target.the("State").located(By.id("id_state"));

    public static final Target ZIP_POSTAL_CODE =
            Target.the("Zip/Postal Code").located(By.id("postcode"));

    public static final Target MOBILE_PHONE =
            Target.the("Mobile Phone").located(By.xpath("//input[@id='phone_mobile']"));

    public static final Target SUBMIT_ACCOUNT =
            Target.the("Submit Account").located(By.id("submitAccount"));

    public static final Target MY_ACCOUNT_PAGE =
            Target.the("My Account Page").located(By.xpath("//h1[@class='page-heading'][contains(string(),'My account')]"));

    public static final Target MESSAGE_EMAIL_REGISTERED =
            Target.the("Message Email Registered")
                    .located(By.xpath("//li[contains(string(),'An account using this email address has already been registered.')]"));
}
