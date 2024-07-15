package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {
    public static final Target ORDER_BUTTON = Target.the("Boton del carrito").locatedBy("//button[contains(text(),'Place Order')]");
    public static final Target NAME_INPUT = Target.the("Nombre").located(By.id("name"));
    public static final Target COUNTRY_INPUT = Target.the("Pais").located(By.id("country"));
    public static final Target CITY_INPUT = Target.the("Ciudad").located(By.id("city"));
    public static final Target CREDIT_CARD_INPUT = Target.the("Tarjeta").located(By.id("card"));
    public static final Target MONTH_INPUT = Target.the("Mes").located(By.id("month"));
    public static final Target YEAR_INPUT = Target.the("Año").located(By.id("year"));
    public static final Target PURCHASE_BUTTON = Target.the("").located(By.xpath("//button[@onclick='purchaseOrder()']"));
    public static final Target FINAL_MESSAGE_H2 = Target.the("").located(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
}
