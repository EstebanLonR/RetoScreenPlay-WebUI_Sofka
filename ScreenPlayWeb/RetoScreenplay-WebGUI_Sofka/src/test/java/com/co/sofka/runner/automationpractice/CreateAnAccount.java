package com.co.sofka.runner.automationpractice;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/automationpractice/createAnAccount.feature",
        glue = "com.co.sofka.stepdefinition.automationpractice.createanaccount",
        tags = "",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CreateAnAccount {
}
