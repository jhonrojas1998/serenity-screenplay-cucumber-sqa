package co.com.sqasa.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import co.com.sqasa.userinterfaces.OrderSummaryPage;

public class OrderSummaryText {
    public static Question<String> value() {
        return Text.of(OrderSummaryPage.ORDER_SUMMARY_TITLE).asString();
    }
}
