package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductoPage {
    public static final Target ADDCAR_BUTTON = Target.the("Boton agregar al carrito").locatedBy("//a[contains(text(),'Add to cart')]");
}
