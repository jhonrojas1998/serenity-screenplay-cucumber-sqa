package co.com.sqasa.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.sqasa.userinterfaces.AddProductPage;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class AddSecondProductToCart implements Task {
    private final int quantity;

    public AddSecondProductToCart(int quantity) {
        this.quantity = quantity;
    }

    @Override
    @Step("{0} selecciona el segundo producto disponible con cantidad '#quantity' y lo añade al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AddProductPage.CATEGORY_AMOR),
                WaitUntil.the(AddProductPage.SECOND_PRODUCT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(AddProductPage.SECOND_PRODUCT), // Nuevo Target para el segundo producto
                Clear.field(AddProductPage.QUANTITY_INPUT),
                Enter.theValue(String.valueOf(quantity)).into(AddProductPage.QUANTITY_INPUT),
                Click.on(AddProductPage.ADD_TO_CART_BUTTON)
        );
    }

    public static AddSecondProductToCart withQuantity(int quantity) {
        return instrumented(AddSecondProductToCart.class, quantity);
    }
}
