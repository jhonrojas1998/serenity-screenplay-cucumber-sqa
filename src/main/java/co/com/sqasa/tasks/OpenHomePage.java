package co.com.sqasa.tasks;

import co.com.sqasa.userinterfaces.HomePage;
import co.com.sqasa.userinterfaces.SanAngelHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.annotations.Subject;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenHomePage implements Task {

    private final String usuario;
    private final String contrasena;

    public OpenHomePage(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static OpenHomePage loginWith(String usuario, String contrasena) {
        return instrumented(OpenHomePage.class, usuario, contrasena);
    }

    @Override
    @Subject("Abrir la página e iniciar sesión")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(SanAngelHomePage.class),
                Enter.theValue(usuario).into(HomePage.USERNAME_FIELD),
                Enter.theValue(contrasena).into(HomePage.PASSWORD_FIELD),
                Click.on(HomePage.LOGIN_BUTTON)
        );
    }
}
