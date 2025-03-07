package co.com.sqasa.tasks;

import co.com.sqasa.userinterfaces.DeliveryFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectDeliveryDateAndTime implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String today = Text.of(DeliveryFormPage.DELIVERY_DATE).answeredBy(actor); // Se usa 'answeredBy' en lugar de 'viewedBy'

        actor.attemptsTo(
                // Clic en la fecha de entrega y selección del día 21
                Click.on(DeliveryFormPage.DELIVERY_DATE),
                Click.on(DeliveryFormPage.DELIVERY_DAY.of("21")),


                // Seleccionar el horario de entrega
                Click.on(DeliveryFormPage.DELIVERY_SCHEDULE),
                SelectFromOptions.byIndex(1).from(DeliveryFormPage.DELIVERY_SCHEDULE), // Selecciona la segunda opción
                Click.on(DeliveryFormPage.CONFIRM_BUTTON),

                WaitUntil.the(DeliveryFormPage.DELIVERY_SCHEDULE, isVisible()).forNoMoreThan(10).seconds()

        );
    }

    public static SelectDeliveryDateAndTime now() {
        return new SelectDeliveryDateAndTime();
    }
}
