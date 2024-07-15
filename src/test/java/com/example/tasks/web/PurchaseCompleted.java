package com.example.tasks.web;

import com.example.userinterfaces.pages.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PurchaseCompleted implements Task {

    @Override
    @Step("{0} Termina la compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CarritoPage.PURCHASE_BUTTON, isVisible()).forNoMoreThan(3).seconds(),
                Click.on(CarritoPage.PURCHASE_BUTTON),
                WaitUntil.the(CarritoPage.FINAL_MESSAGE_H2, isVisible()).forNoMoreThan(3).seconds()
        );
    }

    public static Performable finalizarCompra() {
        return instrumented(PurchaseCompleted.class);
    }
}
