// Importa las clases necesarias para Selenium, TestNG y otras utilidades
import pages.loginPage.LoginPageBasic;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Declaración de la clase de prueba BasicLoginTest
public class BasicLoginTest {

    WebDriver driver; // Objeto WebDriver para interactuar con el navegador
    LoginPageBasic login; // Instancia de la clase LoginPageBasic para interactuar con la página de inicio de sesión

    // Método de configuración que se ejecuta antes de las pruebas
    @BeforeTest
    void setup() {
        // Configura el WebDriver para Chrome utilizando WebDriverManager y crea una instancia del navegador
        driver = WebDriverManager.chromedriver().create();
        // Inicializa la instancia de LoginPageBasic con el objeto WebDriver proporcionado
        login = new LoginPageBasic(driver);
    }

    // Método de limpieza que se ejecuta después de las pruebas
    @AfterTest
    void teardown() {
        // Cierra el navegador después de las pruebas
        driver.quit();
    }

    // Método de prueba para verificar el inicio de sesión exitoso
    @Test
    void testBasicLoginSuccess() {
        // Llama al método 'with' de LoginPageBasic para ingresar credenciales y hace una afirmación de que el cuadro de éxito está presente
        login.with("user", "user");
        Assert.assertTrue(login.successBoxPresent(), "Credenciales incorrectas");
    }

    // Método de prueba para verificar el inicio de sesión fallido
    @Test
    void testBasicLoginFailure() {
        // Llama al método 'with' de LoginPageBasic con credenciales incorrectas y hace una afirmación de que el cuadro de éxito no está presente
        login.with("bad-user", "bad-password");
        Assert.assertFalse(login.successBoxPresent(), "Las credenciales deberían ser incorrectas");
    }
}
