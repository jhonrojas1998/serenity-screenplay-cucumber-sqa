package co.com.sqasa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public static final Target USERNAME_FIELD = Target.the("campo de usuario")
            .located(By.id("username"));

    public static final Target PASSWORD_FIELD = Target.the("campo de contraseña")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("botón de inicio de sesión")
            .located(By.name("login"));
}

