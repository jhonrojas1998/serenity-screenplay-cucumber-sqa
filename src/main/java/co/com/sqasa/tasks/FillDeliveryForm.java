package co.com.sqasa.tasks;

import co.com.sqasa.userinterfaces.DeliveryFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillDeliveryForm implements Task {
    private final String fullName;
    private final String municipality;
    private final String address;
    private final String neighborhood;
    private final String phone;
    private final String cardMessage;
    private final String signature;
    private final String observations;

    public FillDeliveryForm(String fullName, String municipality, String address, String neighborhood,
                            String phone, String cardMessage, String signature, String observations) {
        this.fullName = fullName;
        this.municipality = municipality;
        this.address = address;
        this.neighborhood = neighborhood;
        this.phone = phone;
        this.cardMessage = cardMessage;
        this.signature = signature;
        this.observations = observations;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Llenar los campos de texto
                Enter.theValue(fullName).into(DeliveryFormPage.FULL_NAME),
                Enter.theValue(address).into(DeliveryFormPage.ADDRESS),
                Enter.theValue(neighborhood).into(DeliveryFormPage.NEIGHBORHOOD),
                Enter.theValue(phone).into(DeliveryFormPage.PHONE),
                Enter.theValue(cardMessage).into(DeliveryFormPage.CARD_MESSAGE),
                Enter.theValue(signature).into(DeliveryFormPage.SIGNATURE),
                Enter.theValue(observations).into(DeliveryFormPage.OBSERVATIONS),

                // Seleccionar el municipio
                Scroll.to(DeliveryFormPage.MUNICIPIO),
                WaitUntil.the(DeliveryFormPage.MUNICIPIO, isVisible()).forNoMoreThan(10).seconds(),
                SelectFromOptions.byVisibleText(municipality).from(DeliveryFormPage.MUNICIPIO),

                // Confirmar formulario
                Click.on(DeliveryFormPage.CONFIRM_BUTTON)
        );
    }

    public static FillDeliveryForm withData(String fullName, String municipality, String address, String neighborhood,
                                            String phone, String cardMessage, String signature, String observations) {
        return new FillDeliveryForm(fullName, municipality, address, neighborhood, phone, cardMessage, signature, observations);
    }
}
