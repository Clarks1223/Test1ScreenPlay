package com.example.tasks.web;

import com.example.userinterfaces.pages.ProductoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProduct implements Task {

    public static Performable producto() {
        return instrumented(AddProduct.class);
    }

    @Override
    @Step("{0} Se agrega el producto al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar a que el botón de añadir al carrito sea visible
                WaitUntil.the(ProductoPage.ADDCAR_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(ProductoPage.ADDCAR_BUTTON)
        );
        // Aceptar la alerta que puede aparecer después de hacer clic en el botón
        acceptAlert();
    }

    private void acceptAlert() {
        WebDriver driver = net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight()
                .usingAbilityTo(net.serenitybdd.screenplay.abilities.BrowseTheWeb.class)
                .getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
