package com.example.tasks.web;

import com.example.userinterfaces.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateCart implements Task {

    @Override
    @Step("{0} Navigates to the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.CART_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(HomePage.CART_BUTTON)
        );
    }

    public static Performable irACarrito() {
        return instrumented(NavigateCart.class);
    }
}
