package com.co.sofka.stepdefinition.automationpractice.createanaccount;


import com.co.sofka.question.createanaccount.MyAccountPage;
import com.co.sofka.stepdefinition.automationpractice.SetUp;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import java.util.List;

import static com.co.sofka.question.createanaccount.ErrorMessageEmailRegistered.errorMessageEmailRegistered;
import static com.co.sofka.question.createanaccount.MyAccountPage.*;
import static com.co.sofka.task.automationpractice.GoToCreateAnAccount.goToCreateAnAccount;
import static com.co.sofka.task.automationpractice.createanaccount.FillCreateAccountFormWithEmailRegistered.fillCreateAccountFormWithEmailRegistered;
import static com.co.sofka.task.automationpractice.createanaccount.FillCreateAnAccountForm.fillCreateAnAccountForm;
import static com.co.sofka.userinterface.automationpractice.MainPage.BASE_URL_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateAnAccountStepDefinitions extends SetUp {
    private final Logger LOGGER = Logger.getLogger(CreateAnAccountStepDefinitions.class);
    private static final String ACTOR_NAME = "User";

    @Given("el usuario se encuentra en la pagina principal del aplicativo")
    public void elUsuarioSeEncuentraEnLaPaginaPrincipalDelAplicativo() {
        actorSetUpBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(Open.url(BASE_URL_PAGE));
    }

    @When("el se dirige al apartado de Register")
    public void elSeDirigeAlApartadoDeRegister() {
        theActorInTheSpotlight().attemptsTo(goToCreateAnAccount());
    }

    @When("diligencia el formulario de registro con sus informacion")
    public void diligenciaElFormularioDeRegistroConSusInformacion(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(fillCreateAnAccountForm()
                .usingEmail(rows.get(1).get(0))
                .usingTheTitle(rows.get(1).get(1))
                .usingFirstName(rows.get(1).get(2))
                .usingLastName(rows.get(1).get(3))
                .usingThePassword(rows.get(1).get(4))
                .usingTheAddress(rows.get(1).get(5))
                .withTheCity(rows.get(1).get(6))
                .andState(rows.get(1).get(7))
                .whichHasZipCode(rows.get(1).get(8))
                .usingThePhoneNumber(rows.get(1).get(9)));
    }

    @Then("el debera de ver la pagina {string}")
    public void elDeberaDeVerLaPagina(String pageTitle) {
        theActorInTheSpotlight().should(seeThat(myAccountPage(), Matchers.containsString(pageTitle)));
    }

    //@@CreateAccountWithEmailRegistered
    @When("diligencia su correo {string}")
    public void diligenciaSuCorreo(String email) {
        theActorInTheSpotlight().attemptsTo(fillCreateAccountFormWithEmailRegistered()
                .usingEmail(email));
    }

    @Then("el sistema debera mostrarle un mensaje de error {string}")
    public void elSistemaDeberaMostrarleUnMensajeDeError(String messageError) {
        theActorInTheSpotlight().should(seeThat(errorMessageEmailRegistered(), Matchers.containsString(messageError)));
        LOGGER.info(messageError);
    }

}
