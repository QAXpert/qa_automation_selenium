package pages;// Importa las clases necesarias de Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Declaración de la clase pages.BasePage, que proporciona funciones comunes para interactuar con páginas web
public class BasePage {

    WebDriver driver; // Objeto WebDriver para interactuar con el navegador
    WebDriverWait wait; // Objeto WebDriverWait para esperas explícitas
    int timeoutSec = 5; // Tiempo de espera predeterminado en segundos (5 segundos por defecto)

    // Constructor de la clase pages.BasePage que recibe un objeto WebDriver y configura la espera explícita
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    // Método para establecer el tiempo de espera explícita
    public void setTimeoutSec(int timeoutSec) {
        this.timeoutSec = timeoutSec;
    }

    // Método para visitar una URL dada
    public void visit(String url) {
        driver.get(url);
    }

    // Método para encontrar un elemento mediante un localizador (By)
    public WebElement find(By element) {
        return driver.findElement(element);
    }

    // Método para hacer clic en un elemento identificado por un localizador (By)
    public void click(By element) {
        find(element).click();
    }

    // Método para escribir texto en un elemento identificado por un localizador (By)
    public void type(By element, String text) {
        find(element).sendKeys(text);
    }

    // Método para verificar si un elemento identificado por un localizador (By) está visible
    public boolean isDisplayed(By locator) {
        try {
            // Espera hasta que el elemento esté visible en la página
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            // Captura la excepción de TimeoutException y retorna false si el elemento no está visible después del tiempo de espera
            return false;
        }
        // Retorna true si el elemento está visible
        return true;
    }
    public String getAttributeUsername(By element) {
        return  find(element).getAttribute("type");
    }
}
