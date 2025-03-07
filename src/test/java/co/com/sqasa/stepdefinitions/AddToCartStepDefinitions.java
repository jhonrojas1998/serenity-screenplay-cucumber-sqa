package co.com.sqasa.stepdefinitions;

import co.com.sqasa.questions.OrderSummaryText;
import co.com.sqasa.tasks.*;
import co.com.sqasa.userinterfaces.DeliveryFormPage;
import co.com.sqasa.userinterfaces.OrderSummaryPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddToCartStepDefinitions {

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());

    }

    @Given("el usuario inicia sesion con {string} y {string}")
    public void elUsuarioIniciaSesionConY(String usuario, String contrasena) {
        OnStage.theActorCalled("Usuario").attemptsTo(
                OpenHomePage.loginWith(usuario, contrasena)
        );

    }


    @When("selecciona el primer producto disponible con cantidad dos y lo anade al carrito")
    public void seleccionaElPrimerProductoDisponibleConCantidadDosYLoAnadeAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.withFirstAvailable(2)
        );
    }

    @Given("selecciona el producto Caja Agata  rosas con cantidad siete y lo anade al carrito")
    public void seleccionaElProductoCajaAgataRosasConCantidadSieteYLoAnadeAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AddSecondProductToCart.withQuantity(7)
        );
    }

    @When("diligencia el formulario de informacion de entrega con {string}, {string}, {string}, {string}, {string}, {string}, {string} y {string}")
    public void diligenciaElFormularioDeInformacionDeEntrega(String nombreCompleto, String municipio, String direccion,
                                                             String barrio, String telefono, String mensajeTarjeta,
                                                             String firma, String observaciones) {
        theActorInTheSpotlight().attemptsTo(
                FillDeliveryForm.withData(nombreCompleto, municipio, direccion, barrio, telefono, mensajeTarjeta, firma, observaciones)
        );
    }
    @And("selecciona la fecha y el horario de entrega")
    public void seleccionaLaFechaYElHorarioDeEntrega() {
        theActorInTheSpotlight().attemptsTo(
                SelectDeliveryDateAndTime.now()
        );
    }






    @And("hace clic en Realizar pedido")
    public void haceClicEnRealizarPedido() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(DeliveryFormPage.CONFIRM_BUTTON)
        );
    }


    @Then("el sistema muestra el resumen de la compra")
    public void verificaResumenCompra() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(OrderSummaryPage.ORDER_SUMMARY_TITLE, isVisible()).forNoMoreThan(10).seconds()
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat("Resumen de la compra", OrderSummaryText.value(), equalTo("Resumen de la compra"))
        );
    }


}