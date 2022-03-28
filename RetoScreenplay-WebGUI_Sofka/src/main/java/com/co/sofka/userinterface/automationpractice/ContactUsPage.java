package com.co.sofka.userinterface.automationpractice;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactUsPage {
    public static final Target SUBJECT_HEADING =
            Target.the("Subject Heading").located(By.id("id_contact"));

    public static final Target EMAIL =
            Target.the("Email").located(By.id("email"));

    public static final Target ORDER_REFERENCE =
            Target.the("Order Reference").located(By.id("id_order"));

    public static final Target MESSAGE =
            Target.the("Message").located(By.id("message"));

    public static final Target BUTTON_SEND =
            Target.the("Button Send").located(By.id("submitMessage"));

    public static final Target MESSAGE_SENT_ASSERTION =
            Target.the("Message Sent")
                    .located(By.xpath("//p[@class='alert alert-success'][contains(string(), 'Your message has been successfully sent to our team.')]"));

    public static final Target MESSAGE_ERROR_MESSAGE =
            Target.the("Message Error Message").located(By.xpath("//li[contains(string(),'The message cannot be blank.')]"));
}
