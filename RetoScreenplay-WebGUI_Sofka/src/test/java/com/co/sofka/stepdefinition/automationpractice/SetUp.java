package com.co.sofka.stepdefinition.automationpractice;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import static com.co.sofka.util.log4j.Log4jValues.LOG4J_PROPERTIES_PATH;
import static com.co.sofka.util.log4j.Log4jValues.USER_DIRECTORY;

public class SetUp {
    @Managed
    protected WebDriver webDriver;

    private void setUpBrowser(WebDriver webDriver) {
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
    }

    private void setUpUser(String actor, WebDriver webDriver) {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled(actor);
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(webDriver));
    }

    private void setUpLog4J() {
        PropertyConfigurator.configure(USER_DIRECTORY.getValue() + LOG4J_PROPERTIES_PATH.getValue());
    }

    protected void actorSetUpBrowser(String actor) {
        setUpLog4J();
        setUpBrowser(webDriver);
        setUpUser(actor, webDriver);
    }
}
