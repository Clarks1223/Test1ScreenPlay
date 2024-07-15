package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {
    public static final Target PRODUCTNAME1_IMG = Target.the("Imagen de elemento a comprar").locatedBy("//a[contains(text(),'Samsung galaxy s6')]");
    public static final Target PRODUCTNAME2_IMG = Target.the("Imagen de elemento a comprar").locatedBy("//a[contains(text(),'Nexus 6')]");
    public static final Target CART_BUTTON = Target.the("Boton del carrito").located(By.id("cartur"));
    public static final Target HOME_BUTTON = Target.the("Boton de home").locatedBy("//a[@class='nav-link' and contains(text(),'Home')]");
}
