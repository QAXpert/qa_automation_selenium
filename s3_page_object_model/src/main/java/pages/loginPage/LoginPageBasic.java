// Importa las clases necesarias para Selenium y otras utilidades de Java
package pages.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;

// Declaración de la clase LoginPageBasic
public class LoginPageBasic {

    // Declaración de variables de clase
    WebDriver driver; // Objeto WebDriver para interactuar con el navegador
    By usernameInput = By.id("username"); // Localizador del campo de entrada de nombre de usuario
    By passwordInput = By.id("password"); // Localizador del campo de entrada de contraseña
    By submitButton = By.cssSelector("button"); // Localizador del botón de envío del formulario
    By successBox = By.id("successBox"); // Localizador del cuadro de éxito

    // Constructor de la clase LoginPageBasic que recibe un objeto WebDriver como parámetro
    public LoginPageBasic(WebDriver driver) {
        this.driver = driver; // Inicializa el objeto WebDriver con el proporcionado
        // Crea la ruta completa del archivo HTML de la página de prueba
        String filePath = Paths.get("src", "main", "resources", "qaxpertLogin.html").toAbsolutePath().toString();
        // Abre la página de prueba utilizando el protocolo 'file:///' y la ruta del archivo HTML
        driver.get("file:///" + filePath);
        // Maximiza la ventana del navegador
        driver.manage().window().maximize();
    }

    // Método 'with' para ingresar credenciales de usuario y contraseña en los campos correspondientes y hacer clic en el botón de envío
    public void with(String username, String password) {
        // Encuentra el elemento del nombre de usuario y escribe el nombre de usuario proporcionado
        driver.findElement(usernameInput).sendKeys(username);
        // Encuentra el elemento de la contraseña y escribe la contraseña proporcionada
        driver.findElement(passwordInput).sendKeys(password);
        // Encuentra el botón de envío y hace clic en él
        driver.findElement(submitButton).click();
    }

    // Método 'successBoxPresent' que verifica si el cuadro de éxito está presente en la página
    public boolean successBoxPresent() {
        // Utiliza el localizador para encontrar el elemento del cuadro de éxito y verifica si está visible
        return driver.findElement(successBox).isDisplayed();
    }
}
