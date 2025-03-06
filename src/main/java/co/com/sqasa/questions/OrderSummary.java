package co.com.sqasa.questions;

import co.com.sqasa.userinterfaces.OrderSummaryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class OrderSummary implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return OrderSummaryPage.ORDER_SUMMARY_SECTION.resolveFor(actor).isVisible();
    }

    public static OrderSummary isVisible() {
        return new OrderSummary();
    }
}
