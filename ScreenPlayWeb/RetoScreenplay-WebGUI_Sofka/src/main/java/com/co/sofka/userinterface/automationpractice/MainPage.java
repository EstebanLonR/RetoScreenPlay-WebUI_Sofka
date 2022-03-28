package com.co.sofka.userinterface.automationpractice;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {
    public static final String BASE_URL_PAGE = "http://automationpractice.com/index.php";

    public static final Target CUSTOM_CARE_BUTTON =
            Target.the("Custom Care Button").located(By.id("contact-link"));

    public static final Target SING_IN_BUTTON=
            Target.the("Sing In Button").located(By.xpath("//div[@class='header_user_info']//child::a[@class='login']"));
}
