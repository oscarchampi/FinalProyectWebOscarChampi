package org.example.Taks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.example.Pages.HomePage;

public class NavigateHome {
    public static Performable theHomePage(){
        return Task.where("{0} opens home page", Open.browserOn().the(HomePage.class));
    }
}
