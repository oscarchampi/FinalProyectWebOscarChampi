
package org.example.Pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.demoblaze.com/")
public class HomePage extends PageObject {

    public static final Target BTN_REGISTRAR =
            Target.the("Boton para hacer el registro")
                    .located(By.id("signin2"));

    public static final Target INP_USERNAME =
            Target.the("Input USER NAME")
                    .located(By.id("sign-username"));

    public static final Target INP_PASWORD =
            Target.the("Input PASSWORD")
                    .located(By.id("sign-password"));

    public static final Target BTN_REGISTRAR2 =
            Target.the("Boton de registro")
                    .located(By.xpath("//button[@onclick='register()']"));
}
