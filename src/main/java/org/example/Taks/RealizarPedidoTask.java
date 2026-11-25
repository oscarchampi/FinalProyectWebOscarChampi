package org.example.Taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.CartPage;

import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RealizarPedidoTask implements Task {

    private final Map<String, String> datosCompra;

    public RealizarPedidoTask(Map<String, String> datosCompra) {
        this.datosCompra = datosCompra;
    }

    public static RealizarPedidoTask conDatos(Map<String, String> datosCompra) {
        return Tasks.instrumented(RealizarPedidoTask.class, datosCompra);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CartPage.INP_ORDER_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(datosCompra.get("nombre")).into(CartPage.INP_ORDER_NAME),
                Enter.theValue(datosCompra.get("pais")).into(CartPage.INP_ORDER_COUNTRY),
                Enter.theValue(datosCompra.get("ciudad")).into(CartPage.INP_ORDER_CITY),
                Enter.theValue(datosCompra.get("tarjeta")).into(CartPage.INP_ORDER_CARD),
                Enter.theValue(datosCompra.get("mes")).into(CartPage.INP_ORDER_MONTH),
                Enter.theValue(datosCompra.get("anio")).into(CartPage.INP_ORDER_YEAR),
                Click.on(CartPage.BTN_PURCHASE)
        );
    }
}