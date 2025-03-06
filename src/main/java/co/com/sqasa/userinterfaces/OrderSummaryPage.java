package co.com.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderSummaryPage {
    public static final Target ORDER_SUMMARY_SECTION = Target.the("Sección del resumen de la compra")
            .located(By.id("order-summary")); // Reemplaza con el selector correcto
}
