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

public class SelectProduct2 implements Task {

    public static Performable producto() {
        return instrumented(SelectProduct2.class);
    }

    @Override
    @Step("{0} Se agrega el producto")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.PRODUCTNAME2_IMG, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(HomePage.PRODUCTNAME2_IMG)
        );
    }
}
