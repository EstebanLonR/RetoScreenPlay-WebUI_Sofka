package com.co.sofka.stepdefinition.automationpractice.signin;

import com.co.sofka.question.signin.MessageRetrievePassword;
import com.co.sofka.stepdefinition.automationpractice.SetUp;
import com.co.sofka.task.automationpractice.signin.RecoverYourPassword;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import java.util.List;

import static com.co.sofka.question.signin.MessageRetrievePassword.messageRetrievePassword;
import static com.co.sofka.question.signin.ViewCustomerAccount.viewCustomerAccount;
import static com.co.sofka.task.automationpractice.GoToSignIn.goToSignIn;
import static com.co.sofka.task.automationpractice.signin.FillSignInForm.fillSignInForm;
import static com.co.sofka.task.automationpractice.signin.RecoverYourPassword.recoverYourPassword;
import static com.co.sofka.userinterface.automationpractice.MainPage.BASE_URL_PAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SignInStepDefinitions extends SetUp {
    private final Logger LOGGER = Logger.getLogger(SignInStepDefinitions.class);
    private static final String ACTOR_NAME = "User";

    @Given("el usuario se encuentra en la pagina principal del aplicativo")
    public void elUsuarioSeEncuentraEnLaPaginaPrincipalDelAplicativo() {
        actorSetUpBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(Open.url(BASE_URL_PAGE));
    }

    @When("el se dirige al apartado de sing in")
    public void elSeDirigeAlApartadoDeSingIn() {
        theActorInTheSpotlight().attemptsTo(goToSignIn());
    }

    @When("diligencia el formulario con sus credenciales")
    public void diligenciaElFormularioConSusCredenciales(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(fillSignInForm()
                .usingTheEmail(rows.get(1).get(0))
                .usingThePassword(rows.get(1).get(1)));
    }

    @Then("el sistema debera mostrarle su usuario logeado en la pagina")
    public void elSistemaDeberaMostrarleSuUsuarioLogeadoEnLaPagina() {
        theActorInTheSpotlight().should(seeThat(viewCustomerAccount(), Matchers.is(true)));

    }

    //ForgotPassword
    @When("se dirige el apartado de forgot password y manda su email")
    public void seDirigeElApartadoDeForgotPasswordYMandaSuEmail(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        theActorInTheSpotlight().attemptsTo(recoverYourPassword()
                .usingTheEmail(rows.get(1).get(0)));
    }

    @Then("el sistema debera mostrarle el mensaje {string}")
    public void elSistemaDeberaMostrarleElMensaje(String message) {
        theActorInTheSpotlight().should(seeThat(messageRetrievePassword(), Matchers.containsString(message)));
        LOGGER.info(message);
    }
}
