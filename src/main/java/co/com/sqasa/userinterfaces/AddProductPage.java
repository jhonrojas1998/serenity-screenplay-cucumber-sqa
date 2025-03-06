package co.com.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class AddProductPage {
    public static final Target CATEGORY_AMOR = Target.the("Categoría Amor")
            .located(By.xpath("//*[@id='sticky-wrapper']/header/div[2]/nav[1]/ul/li[2]/a"))
            .waitingForNoMoreThan(Duration.ofSeconds(10));

    public static final Target FIRST_PRODUCT = Target.the("Primer producto disponible")
            .located(By.xpath("(//div[contains(@class,'product')]//a)[1]"));

    public static final Target QUANTITY_INPUT = Target.the("Campo de cantidad")
            .located(By.xpath("//input[@type='number']"));

    public static final Target ADD_TO_CART_BUTTON = Target.the("Botón añadir al carrito")
            .located(By.xpath("//button[contains(@class,'add_to_cart')]"));
    public static final Target PRODUCT_BY_NAME = Target.the("Producto específico")
            .locatedBy("//a[contains(text(), '{0}')]");
    public static Target productWithName(String productName) {
        return Target.the("Producto con nombre " + productName)
                .locatedBy("//a[contains(text(),'" + productName + "')]");
    }
    public static final Target SECOND_PRODUCT = Target.the("Segundo producto disponible")
            .located(By.xpath("(//div[contains(@class,'product')]//a)[4]"));



}
