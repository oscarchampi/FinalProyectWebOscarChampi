
package org.example.StepDefinition;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import net.serenitybdd.screenplay.targets.Target;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

import org.example.Pages.AboutUsPage;
import org.example.Pages.CartPage;
import org.example.Pages.ContactPage;
import org.example.Pages.LoginPage;
import org.example.Questions.ResponseCode;
import org.example.Taks.ReproducirVideo;
import org.example.Utils.PreAndProsCondition;
import org.example.Utils.ScreenShot;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.NoSuchElementException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.equalTo;

public class TareaStepDefinition {

    // LOGIN

    @And("el usuario esta logueado en la tienda con usuario {string} y contrasena {string}")
    public void elUsuarioEstaLogueadoEnLaTienda(String username, String password) {

        theActorInTheSpotlight().attemptsTo(
                Click.on(LoginPage.BTN_LOGIN_NAV),
                WaitUntil.the(LoginPage.INP_LOGIN_USERNAME, isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(LoginPage.INP_LOGIN_USERNAME),
                Enter.theValue(password).into(LoginPage.INP_LOGIN_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN_MODAL),
                WaitUntil.the(LoginPage.LBL_USER_LOGGED, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "usuario_logueado"
        );
    }

    // AGREGAR PRODUCTO AL CARRITO

    @When("selecciona la categoria {string}")
    public void seleccionaLaCategoria(String categoria) {

        theActorInTheSpotlight().attemptsTo(
                Click.on(CartPage.OPT_CATEGORIA.of(categoria))
        );
    }

    @And("selecciona el producto {string}")
    public void seleccionaElProducto(String producto) {

        String xpath = "//a[@class='hrefch' and normalize-space(text())='" + producto + "']";

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));

        wait.until(driver -> {
            try {
                WebElement elemento = driver.findElement(By.xpath(xpath));

                if (elemento.isDisplayed() && elemento.isEnabled()) {
                    elemento.click();
                    return true;
                }

            } catch (StaleElementReferenceException | NoSuchElementException e) {
                return false;
            }

            return false;
        });
    }

    @And("agrega el producto al carrito de compras")
    public void agregaElProductoAlCarritoDeCompras() {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CartPage.BTN_ADD_TO_CART, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CartPage.BTN_ADD_TO_CART)
        );

        theActorInTheSpotlight().should(
                seeThat(ResponseCode.alertMessage(), equalTo("Product added."))
        );
    }

    @Given("el usuario agrega el producto {string} de la categoria {string} al carrito")
    public void elUsuarioAgregaElProductoDeLaCategoriaAlCarrito(
            String producto, String categoria) {

        seleccionaLaCategoria(categoria);
        seleccionaElProducto(producto);
        agregaElProductoAlCarritoDeCompras();
    }

    @And("se dirige al carrito de compras")
    public void seDirigeAlCarritoDeCompras() {

        theActorInTheSpotlight().attemptsTo(
                Click.on(CartPage.BTN_CART_NAV)
        );
    }

    @Then("verifica en el carrito que se muestre el producto {string}")
    public void verificaEnElCarritoQueSeMuestreElProducto(String producto) {

        seDirigeAlCarritoDeCompras();

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(
                        CartPage.LBL_PRODUCTO_EN_CARRITO.of(producto),
                        isVisible()
                ).forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        WebElementQuestion.the(
                                CartPage.LBL_PRODUCTO_EN_CARRITO.of(producto)
                        ),
                        isVisible()
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "producto_en_carrito"
        );
    }

    // REALIZAR COMPRA

    @When("inicia el proceso de realizar pedido")
    public void iniciaElProcesoDeRealizarPedido() {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CartPage.BTN_PLACE_ORDER, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CartPage.BTN_PLACE_ORDER)
        );
    }

    @And("ingresa los datos de compra")
    public void ingresaLosDatosDeCompra(DataTable dataTable) {

        Map<String, String> fila =
                dataTable.asMaps(String.class, String.class).get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CartPage.INP_ORDER_NAME, isVisible())
                        .forNoMoreThan(10).seconds(),

                Enter.theValue(fila.get("nombre"))
                        .into(CartPage.INP_ORDER_NAME),

                Enter.theValue(fila.get("pais"))
                        .into(CartPage.INP_ORDER_COUNTRY),

                Enter.theValue(fila.get("ciudad"))
                        .into(CartPage.INP_ORDER_CITY),

                Enter.theValue(fila.get("tarjeta"))
                        .into(CartPage.INP_ORDER_CARD),

                Enter.theValue(fila.get("mes"))
                        .into(CartPage.INP_ORDER_MONTH),

                Enter.theValue(fila.get("anio"))
                        .into(CartPage.INP_ORDER_YEAR)
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "datos_compra"
        );
    }

    @And("confirma la compra")
    public void confirmaLaCompra() {

        theActorInTheSpotlight().attemptsTo(
                Click.on(CartPage.BTN_PURCHASE)
        );
    }

    @Then("realiza su compra de manera exitosa con el mensaje {string}")
    public void realizaSuCompraDeManeraExitosaConElMensaje(String mensajeEsperado) {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CartPage.LBL_COMPRA_EXITOSA, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        Text.of(CartPage.LBL_COMPRA_EXITOSA),
                        equalTo(mensajeEsperado)
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "compra_exitosa"
        );

        theActorInTheSpotlight().attemptsTo(
                Click.on(CartPage.BTN_OK_COMPRA)
        );
    }

    // ELIMINAR PRODUCTO DEL CARRITO

    @When("elimina el producto {string} del carrito")
    public void eliminaElProductoDelCarrito(String producto) {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(
                        CartPage.BTN_ELIMINAR_PRODUCTO.of(producto),
                        isVisible()
                ).forNoMoreThan(10).seconds(),

                Click.on(CartPage.BTN_ELIMINAR_PRODUCTO.of(producto))
        );
    }

    @Then("verifica que el producto {string} ya no se muestre en el carrito")
    public void verificaQueElProductoYaNoSeMuestreEnElCarrito(String producto) {

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(
                        CartPage.LBL_PRODUCTO_EN_CARRITO.of(producto),
                        isNotVisible()
                ).forNoMoreThan(10).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat(
                        WebElementQuestion.the(
                                CartPage.LBL_PRODUCTO_EN_CARRITO.of(producto)
                        ),
                        isNotVisible()
                )
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "producto_eliminado"
        );
    }

    // CONTACTO

    @When("abre el formulario de contacto")
    public void abreElFormularioDeContacto() {

        theActorInTheSpotlight().attemptsTo(
                Click.on(ContactPage.BTN_CONTACT_NAV)
        );
    }

    @And("ingresa los datos de contacto")
    public void ingresaLosDatosDeContacto(DataTable dataTable) {

        Map<String, String> fila =
                dataTable.asMaps(String.class, String.class).get(0);

        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ContactPage.INP_CONTACT_EMAIL, isVisible())
                        .forNoMoreThan(10).seconds(),

                Enter.theValue(fila.get("correo"))
                        .into(ContactPage.INP_CONTACT_EMAIL),

                Enter.theValue(fila.get("nombre"))
                        .into(ContactPage.INP_CONTACT_NAME),

                Enter.theValue(fila.get("mensaje"))
                        .into(ContactPage.INP_CONTACT_MESSAGE)
        );

        ScreenShot.captureScreenshot(
                getDriver(),
                PreAndProsCondition.screenShot,
                "datos_contacto"
        );
    }

    @And("envia el mensaje de contacto")
    public void enviaElMensajeDeContacto() {

        theActorInTheSpotlight().attemptsTo(
                Click.on(ContactPage.BTN_SEND_MESSAGE)
        );
    }



    @When("seleciona el boton de sobre nosotros")
    public void selecionaElBotonDeSobreNosotros() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(AboutUsPage.BTN_ABOUT_US, isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(AboutUsPage.BTN_ABOUT_US)
        );
    }

    @And("reproduce el boton de play")
    public void reproduceElBotonDePlay() {
        theActorInTheSpotlight().attemptsTo(
                ReproducirVideo.delVideo()
        );
    }

    @Then("el video se reproduce correctamente")
    public void elVideoSeReproduceCorrectamente() {
        // Aquí implementaremos la validación del video.
    }
}
