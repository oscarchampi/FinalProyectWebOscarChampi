package org.example.Taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.example.Pages.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private final String username;
    private final String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTask conCredenciales(String username, String password) {
        return Tasks.instrumented(LoginTask.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginPage.BTN_LOGIN_NAV),
                WaitUntil.the(LoginPage.INP_LOGIN_USERNAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(username).into(LoginPage.INP_LOGIN_USERNAME),
                Enter.theValue(password).into(LoginPage.INP_LOGIN_PASSWORD),
                Click.on(LoginPage.BTN_LOGIN_MODAL),
                WaitUntil.the(LoginPage.LBL_USER_LOGGED, isVisible()).forNoMoreThan(10).seconds()
        );
    }
}