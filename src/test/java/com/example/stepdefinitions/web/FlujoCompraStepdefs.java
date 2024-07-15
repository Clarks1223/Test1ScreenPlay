package com.example.stepdefinitions.web;

import com.example.tasks.web.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import net.serenitybdd.screenplay.Actor;


import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FlujoCompraStepdefs {
    private Scenario scenario;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^que el (.*) se encuentra en la página de inicio de DemoBlaze$")
    public void queElClienteSeEncuentraEnLaPáginaDeInicioDeDemoBlaze(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(
                NavigateTo.DemoBlaze()
        );
        screenShot();
    }

    @When("doy clic en el producto  1")
    public void doyClicEnElProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SelectProduct1.producto()
        );
        screenShot();
    }

    @And("agrego un producto 1 al carrito")
    public void agregoUnAlCarrito() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                AddProduct.producto()
        );
        screenShot();
    }

    @And("regreso a la página principal")
    public void regresoalapáginaprincipal() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                NavigateHome.irAHome()
        );
        screenShot();
    }

    @When("doy clic en el producto 2")
    public void doyclicenunproducto() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                SelectProduct2.producto()
        );
        screenShot();
    }

    @And("agrego el producto 2 al carrito")
    public void agregoelproducto() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                AddProduct.producto()
        );
        screenShot();
    }

    @And("visualizo el contenido del carrito")
    public void visualizoElContenidoDelCarrito() {
        Actor actor = OnStage.theActorInTheSpotlight();
        actor.attemptsTo(
                NavigateCart.irACarrito()
        );
        screenShot();
    }

    @And("completo el formulario de compra con mis datos")
    public void completoElFormularioDeCompraConMisDatos(DataTable dataTable) {
        Map<String, String> datosFormulario = dataTable.transpose().asMap(String.class, String.class);
        String name = datosFormulario.get("name");
        String country = datosFormulario.get("country");
        String city = datosFormulario.get("city");
        String card = datosFormulario.get("card");
        String month = datosFormulario.get("month");
        String year = datosFormulario.get("year");

        Actor actor = OnStage.theActorInTheSpotlight();

        actor.attemptsTo(
                RegistredForm.withData(name, country, city, card, month, year)
        );
        screenShot();
    }

    @And("finalizo la compra exitosamente")
    public void finalizoLaCompraExitosamente() {
        Actor actor = OnStage.theActorInTheSpotlight();

        actor.attemptsTo(
                PurchaseCompleted.finalizarCompra()

        );
        screenShot();
    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}
