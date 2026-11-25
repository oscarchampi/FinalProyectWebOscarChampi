package org.example.Utils;

import io.cucumber.java.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class PreAndProsCondition {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreAndProsCondition.class);
    public static String screenShot = Parameters.RutaEvidencia;

    @Before()
    public void beforeScenario(Scenario scenario) {
        LOGGER.info("_____________________________________________________");
        LOGGER.info("Running:" + scenario.getName());
        OnStage.setTheStage(new OnlineCast());
        LOGGER.info("create folder for screenshot");
        screenShot += ScreenShot.getCurrentDateTime() + "_" + scenario.getName();
        Parameters.RutaEvidenciaActual = screenShot;
        ScreenShot.createFolder(screenShot);
        // limpiar sesión del usuario
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("localStorage.removeItem('settings');");
        jsExecutor.executeScript("sessionStorage.removeItem('username');");
        jsExecutor.executeScript("sessionStorage.removeItem('NRBA_SESSION_ID');");

    }

    @After()
    public void afterScenario(Scenario scenario) {
        //realizar alguna acción al finalizar el scenario
        LOGGER.info("finishing:" + scenario.getName());
        screenShot = Parameters.RutaEvidencia;
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        LOGGER.info("finishing:" + scenario.getName());
    }

//    @AfterStep
//    public void afterStep(Scenario scenario) {
//        //adjunta evidencia a jira xray
//        final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot, "image/png", scenario.getName());
//    }
}
