package co.com.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OrderSummaryPage {
    public static final Target ORDER_SUMMARY_TITLE = Target.the("Sección del resumen de la compra")
            .located(By.xpath("//h2[contains(@class, 'highlighted-text') and contains(text(), 'Resumen de la compra')]")); // Reemplaza con el selector correcto
}
