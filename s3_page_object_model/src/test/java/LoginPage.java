// Importa las clases necesarias de Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;

// Declaración de la clase LoginPage que hereda de BasePage para utilizar sus métodos comunes
public class LoginPage extends BasePage {

    // Localizadores (By) para los elementos en la página de inicio de sesión
    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.cssSelector("button");
    By successBox = By.id("success");

    // Constructor de la clase LoginPage que recibe un objeto WebDriver y un tiempo de espera explícita personalizado
    public LoginPage(WebDriver driver, int timeoutSec) {
        // Llama al constructor de la clase base (BasePage) con el objeto WebDriver
        this(driver);
        // Establece el tiempo de espera explícita con el valor personalizado
        setTimeoutSec(timeoutSec);
    }

    // Constructor de la clase LoginPage que recibe solo un objeto WebDriver
    public LoginPage(WebDriver driver) {
        // Llama al constructor de la clase base (BasePage) con el objeto WebDriver
        super(driver);
        // Obtiene la ruta relativa del archivo HTML de la página de inicio de sesión
        String filePath = Paths.get("src", "main", "resources", "qaxpertLogin.html").toAbsolutePath().toString();
        // Visita la página de inicio de sesión utilizando el método visit() de BasePage
        visit("file:///" + filePath);
    }

    // Método para ingresar credenciales y realizar clic en el botón de inicio de sesión
    public void with(String username, String password) {
        // Utiliza los métodos de BasePage (type y click) para ingresar credenciales y hacer clic en el botón
        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);
    }

    // Método para verificar la presencia del cuadro de éxito después de iniciar sesión
    public boolean successBoxPresent() {
        // Utiliza el método isDisplayed de BasePage para verificar la visibilidad del cuadro de éxito
        return isDisplayed(successBox);
    }

}
