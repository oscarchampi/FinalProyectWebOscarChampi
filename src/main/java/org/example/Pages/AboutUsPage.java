package org.example.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AboutUsPage extends PageObject {

    public static final Target BTN_ABOUT_US = Target.the("Boton About Us")
                    .locatedBy("//a[text()='About us']");

    public static final Target BTN_PLAY = Target.the("Boton Play del video")
                    .locatedBy("//button[contains(@class,'vjs-big-play-button')]");

}