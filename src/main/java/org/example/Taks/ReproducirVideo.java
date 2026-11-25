package org.example.Taks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.example.Pages.AboutUsPage;

public class ReproducirVideo implements Task {

    public static ReproducirVideo delVideo() {
        return instrumented(ReproducirVideo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AboutUsPage.BTN_PLAY, isVisible())
                        .forNoMoreThan(15).seconds(),
                Click.on(AboutUsPage.BTN_PLAY)
        );
    }
}