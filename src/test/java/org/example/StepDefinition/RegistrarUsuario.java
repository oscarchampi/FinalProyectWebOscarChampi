
package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.example.Pages.HomePage;
import org.example.Questions.ResponseCode;
import org.example.Taks.NavigateHome;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegistrarUsuario {

    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateHome.theHomePage());
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"paso uno");
    }

    @And("seleciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePage.BTN_REGISTRAR)
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"paso dos");

    }

    @And("ingresa un nombre de usuario {string} y contrasena {string}")
    public void ingresaUnNombreDeUsuarioYContrasenia(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Enter.theValue(username).into(HomePage.INP_USERNAME),
                Enter.theValue(password).into(HomePage.INP_PASWORD)
        );
        ScreenShot.captureScreenshot(getDriver(), PreAndProsCondition.screenShot,"paso tres");

    }

    @When("seleciona el boton registrar")
    public void seleccionElBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(HomePage.BTN_REGISTRAR2)
        );

    }

    @Then("realizar el registro de manera correcta")
    public void realizarElRegistroDeManeraCorrecta() {
        theActorInTheSpotlight().should(
                seeThat(
                        ResponseCode.alertMessage(),
                        equalTo("Sign up successful.")
                )
        );
    }
    @Then("muestra el mensaje de alerta {string}")
    public void muestraElMensajeDeAlerta(String mensaje) {
        theActorInTheSpotlight().should(
                seeThat(
                        ResponseCode.alertMessage(),
                        equalTo(mensaje)
                )
        );
    }
}
