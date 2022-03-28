package com.co.sofka.stepdefinition.automationpractice.contactus;

import com.co.sofka.question.contactus.MessageError;
import com.co.sofka.stepdefinition.automationpractice.SetUp;

import com.co.sofka.task.automationpractice.contactus.FillFormContacUsWithoutMessage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import java.util.List;

import static com.co.sofka.question.contactus.MessageError.*;
import static com.co.sofka.question.contactus.MessageSuccesfullySent.messageSuccesfullySentMessage;
import static com.co.sofka.task.automationpractice.GoToContactUs.goToContactUs;
import static com.co.sofka.task.automationpractice.contactus.FillFormContacUs.fillFormContacUs;
import static com.co.sofka.task.automationpractice.contactus.FillFormContacUsWithoutMessage.*;
import static com.co.sofka.userinterface.automationpractice.MainPage.BASE_URL_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ContactUsStepDefinitions extends SetUp {
    private final Logger LOGGER = Logger.getLogger(ContactUsStepDefinitions.class);
    private static final String ACTOR_NAME = "User";

    @Given("el usuario se encuentra en la pagina principal del aplicativo")
    public void elUsuarioSeEncuentraEnLaPaginaPrincipalDelAplicativo() {
        actorSetUpBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(Open.url(BASE_URL_PAGE));
    }

    @When("se dirige al apartado de contact us")
    public void seDirigeAlApartadoDeContactUs() {
        theActorInTheSpotlight().attemptsTo(goToContactUs());
    }

    @When("diligencia el formulario de customer service")
    public void diligenciaElFormularioDeCustomerService(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(fillFormContacUs()
                .usingTheEmail(rows.get(1).get(0))
                .typeTheReference(rows.get(1).get(1))
                .typeTheMessage(rows.get(1).get(2)));
    }

    @Then("el sistema debera mostrarle un mensaje de confirmando que su mensaje ha sido enviado")
    public void elSistemaDeberaMostrarleUnMensajeDeConfirmandoQueSuMensajeHaSidoEnviado() {
        theActorInTheSpotlight().should(seeThat(messageSuccesfullySentMessage(), Matchers.is(true)));
    }

    //@ErrorContactUs
    @When("diligencia el formulario de customer service sin mensaje")
    public void diligenciaElFormularioDeCustomerServiceSinMensaje(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(fillFormContacUsWithoutMessage()
                .usingTheEmail(rows.get(1).get(0))
                .typeTheReference(rows.get(1).get(1)));
    }

    @Then("el sistema debera mostrarle un mensaje {string}")
    public void elSistemaDeberaMostrarleUnMensaje(String messageError) {
        theActorInTheSpotlight().should(seeThat(messageError(), Matchers.containsString(messageError)));
        LOGGER.info(messageError);
    }

}
