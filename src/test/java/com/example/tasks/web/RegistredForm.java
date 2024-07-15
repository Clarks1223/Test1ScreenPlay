package com.example.tasks.web;

import com.example.userinterfaces.pages.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class RegistredForm implements Task {
    private final String name;
    private final String country;
    private final String city;
    private final String card;
    private final String month;
    private final String year;

    public RegistredForm(String name, String country, String city, String card, String month, String year) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.card = card;
        this.month = month;
        this.year = year;
    }
    public static RegistredForm withData(String name, String country, String city, String card, String month, String year) {
        return instrumented(RegistredForm.class, name, country, city, card, month, year);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CarritoPage.ORDER_BUTTON, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CarritoPage.ORDER_BUTTON),

                WaitUntil.the(CarritoPage.NAME_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(name).into(CarritoPage.NAME_INPUT),

                WaitUntil.the(CarritoPage.COUNTRY_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(country).into(CarritoPage.COUNTRY_INPUT),

                WaitUntil.the(CarritoPage.CITY_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(city).into(CarritoPage.CITY_INPUT),

                WaitUntil.the(CarritoPage.CREDIT_CARD_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(card).into(CarritoPage.CREDIT_CARD_INPUT),

                WaitUntil.the(CarritoPage.MONTH_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(month).into(CarritoPage.MONTH_INPUT),

                WaitUntil.the(CarritoPage.YEAR_INPUT, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(year).into(CarritoPage.YEAR_INPUT)
        );
    }
}
