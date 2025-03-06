package co.com.sqasa.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import co.com.sqasa.userinterfaces.AddProductPage;

public class AddSpecificProductToCart implements Task {
    private final String productName;
    private final int quantity;

    public AddSpecificProductToCart(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    @Override
    @Step("{0} selecciona el producto '#productName' con cantidad '#quantity' y lo añade al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AddProductPage.CATEGORY_AMOR),
                Click.on(AddProductPage.productWithName(productName)), // Método para ubicar el producto por nombre
                Clear.field(AddProductPage.QUANTITY_INPUT),
                Enter.theValue(String.valueOf(quantity)).into(AddProductPage.QUANTITY_INPUT),
                Click.on(AddProductPage.ADD_TO_CART_BUTTON)
        );
    }

    public static AddSpecificProductToCart withNameAndQuantity(String productName, int quantity) {
        return instrumented(AddSpecificProductToCart.class, productName, quantity);
    }
}
