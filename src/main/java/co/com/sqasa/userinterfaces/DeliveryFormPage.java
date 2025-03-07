package co.com.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DeliveryFormPage {
    public static final Target FULL_NAME = Target.the("Campo nombre completo")
            .located(By.id("order_nombre_completo"));

    public static final Target MUNICIPIO = Target.the("Campo municipio")
            .located(By.id("order_ciudad"));

    public static final Target ADDRESS = Target.the("Campo dirección")
            .located(By.id("order_additional_address"));

    public static final Target NEIGHBORHOOD = Target.the("Campo barrio")
            .located(By.id("order_additional_address_2"));

    public static final Target PHONE = Target.the("Campo teléfono")
            .located(By.id("order_additional_phone"));

    public static final Target CARD_MESSAGE = Target.the("Campo mensaje tarjeta")
            .located(By.id("order_comments"));

    public static final Target SIGNATURE = Target.the("Campo firma")
            .located(By.id("order_additional_card_signature"));

    public static final Target DELIVERY_DATE = Target.the("Campo fecha de entrega")
            .located(By.id("order_additional_date"));
    public static final Target DELIVERY_DAY = Target.the("Día de entrega seleccionado")
            .locatedBy("//td[@class='day' and text()='{0}']");


    public static final Target DAY_21 = Target.the("Día 21 en el calendario")
            .located(By.xpath("//td[contains(text(),'21')]")); // Ajustar XPath si es necesario

    public static final Target DELIVERY_SCHEDULE = Target.the("Campo horario de entrega")
            .located(By.id("order_additional_time"));


    public static final Target OBSERVATIONS = Target.the("Campo observaciones")
            .located(By.id("order_additional_card_message"));

    public static final Target CONFIRM_BUTTON = Target.the("Botón confirmar entrega")
            .located(By.id("place_order"));


}
