package co.com.sqasa.tasks;

import co.com.sqasa.userinterfaces.AddProductPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductToCart implements Task {

    private final int quantity;

    public AddProductToCart(int quantity) {
        this.quantity = quantity;
    }

    @Override
    @Step("{0} selecciona la categoría Amor, el primer producto, ajusta la cantidad y lo añade al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AddProductPage.CATEGORY_AMOR, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(AddProductPage.CATEGORY_AMOR),
                Click.on(AddProductPage.FIRST_PRODUCT),
                Clear.field(AddProductPage.QUANTITY_INPUT),
                Enter.theValue(String.valueOf(quantity)).into(AddProductPage.QUANTITY_INPUT),
                Click.on(AddProductPage.ADD_TO_CART_BUTTON)
        );
    }

    public static AddProductToCart withFirstAvailable(int quantity) {
        return instrumented(AddProductToCart.class, quantity);
    }
}
