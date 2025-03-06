package co.com.sqasa.tasks;

import co.com.sqasa.userinterfaces.DeliveryFormPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.questions.Text;

public class SelectDeliveryDateAndTime implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String today = Text.of(DeliveryFormPage.DELIVERY_DATE).answeredBy(actor); // Se usa 'answeredBy' en lugar de 'viewedBy'

        actor.attemptsTo(
                // Clic en la fecha de entrega y selección del día 21
                Click.on(DeliveryFormPage.DELIVERY_DATE),
                Click.on(DeliveryFormPage.DELIVERY_DAY.of("21")),

                // Seleccionar el horario de entrega
                SelectFromOptions.byVisibleText("Entre 9:00 a.m. y 1:00 pm. (Cierra 11:00 am del mismo día)")
                        .from(DeliveryFormPage.DELIVERY_SCHEDULE)
        );
    }

    public static SelectDeliveryDateAndTime now() {
        return new SelectDeliveryDateAndTime();
    }
}
