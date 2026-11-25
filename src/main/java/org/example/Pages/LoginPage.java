package org.example.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage extends PageObject {

    public static final Target BTN_LOGIN_NAV = Target.the("Boton Log in navbar")
            .locatedBy("//a[@id='login2']");
    public static final Target INP_LOGIN_USERNAME = Target.the("Input usuario login")
            .locatedBy("//input[@id='loginusername']");
    public static final Target INP_LOGIN_PASSWORD = Target.the("Input password login")
            .locatedBy("//input[@id='loginpassword']");
    public static final Target BTN_LOGIN_MODAL = Target.the("Boton Log in modal")
            .locatedBy("//div[@id='logInModal']//button[text()='Log in']");
    public static final Target LBL_USER_LOGGED = Target.the("Usuario logueado")
            .locatedBy("//a[@id='nameofuser']");
}