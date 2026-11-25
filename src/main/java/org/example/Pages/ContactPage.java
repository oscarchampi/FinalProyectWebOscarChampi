package org.example.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ContactPage extends PageObject {

    public static final Target BTN_CONTACT_NAV = Target.the("Boton Contact navbar")
            .locatedBy("//a[text()='Contact']");
    public static final Target INP_CONTACT_EMAIL = Target.the("Input Contact Email")
            .locatedBy("//input[@id='recipient-email']");
    public static final Target INP_CONTACT_NAME = Target.the("Input Contact Name")
            .locatedBy("//input[@id='recipient-name']");
    public static final Target INP_CONTACT_MESSAGE = Target.the("Textarea Message")
            .locatedBy("//textarea[@id='message-text']");
    public static final Target BTN_SEND_MESSAGE = Target.the("Boton Send message")
            .locatedBy("//button[text()='Send message']");
}