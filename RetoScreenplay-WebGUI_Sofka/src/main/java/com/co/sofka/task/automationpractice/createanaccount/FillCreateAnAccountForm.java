package com.co.sofka.task.automationpractice.createanaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.conditions.Check;

import static com.co.sofka.userinterface.automationpractice.CreateAnAccountPage.*;
import static com.co.sofka.util.createanaccount.State.*;
import static com.co.sofka.util.createanaccount.Title.MR;

public class FillCreateAnAccountForm implements Task {
    private String email;
    private String title;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;

    public FillCreateAnAccountForm usingEmail(String email) {
        this.email = email;
        return this;
    }

    public FillCreateAnAccountForm usingTheTitle(String title) {
        this.title = title;
        return this;
    }

    public FillCreateAnAccountForm usingFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillCreateAnAccountForm usingLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FillCreateAnAccountForm usingThePassword(String password) {
        this.password = password;
        return this;
    }

    public FillCreateAnAccountForm usingTheAddress(String address) {
        this.address = address;
        return this;
    }

    public FillCreateAnAccountForm withTheCity(String city) {
        this.city = city;
        return this;
    }

    public FillCreateAnAccountForm andState(String state) {
        this.state = state;
        return this;
    }

    public FillCreateAnAccountForm whichHasZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public FillCreateAnAccountForm usingThePhoneNumber(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL_CREATE),
                SendKeys.of(email).into(EMAIL_CREATE),
                Click.on(SUBMIT_CREATE),
                Check.whether(MR.getValue().equals(title))
                        .andIfSo(Scroll.to(TITLE_MALE),
                                Click.on(TITLE_MALE))
                        .otherwise(Scroll.to(TITLE_FEMALE),
                                Click.on(TITLE_FEMALE)),
                Scroll.to(FIRST_NAME),
                SendKeys.of(firstName).into(FIRST_NAME),
                Scroll.to(LAST_NAME),
                SendKeys.of(lastName).into(LAST_NAME),
                Scroll.to(PASSWORD),
                SendKeys.of(password).into(PASSWORD),
                Scroll.to(ADDRESS),
                SendKeys.of(address).into(ADDRESS),
                Scroll.to(CITY),
                SendKeys.of(city).into(CITY),
               SelectFromOptions.byIndex(1).from(STATE),
               Check.whether(ALABAMA.getValue().equals(state.trim()))
                        .andIfSo(SelectFromOptions.byIndex(1).from(STATE))
                        .otherwise(
                                Check.whether(ALASKA.getValue().equals(state.trim()))
                                        .andIfSo(SelectFromOptions.byIndex(2).from(STATE))
                                        .otherwise(
                                                Check.whether(ARIZONA.getValue().equals(state.trim())))
                                                        .andIfSo(SelectFromOptions.byIndex(3).from(STATE))
                                                        .otherwise(
                                                                Check.whether(DELAWERE.getValue().equals(state.trim()))
                                                                        .andIfSo(SelectFromOptions.byIndex(8).from(STATE)))),

                Scroll.to(ZIP_POSTAL_CODE),
                SendKeys.of(zipCode).into(ZIP_POSTAL_CODE),
                SendKeys.of(phone).into(MOBILE_PHONE),
                Click.on(SUBMIT_ACCOUNT)

        );
    }

    public static FillCreateAnAccountForm fillCreateAnAccountForm() {
        return new FillCreateAnAccountForm();
    }
}
