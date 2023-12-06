package pages.WebFormPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WebFormPage {


    protected WebDriver driver;
    // Método que recibirá el driver en esta clase
    public WebFormPage(WebDriver driver) {
        this.driver = driver;
    }


    // Definimos objetos de tipo locator y le asignamos la localización By.
    private By bnt_agendar = By.xpath("//button[contains(.,'Agendar')]");
    private By name = By.id("nombre");
    private By email = By.id("email");
    private By edad = By.id("edad");

    private  By btn_send = By.xpath("//button[contains(text(),'Send')]");


    // Método que realizara un click en bnt_agendar
    public void EnviarInformacion() {
        driver.findElement(btn_send).click();
    }


    // Método que realizara recibira un localizador e ingresara un texto
    public void fillText(By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    // Métodos que realizara recibiran un texto a llenar en cada campo
    public void fillName(String text) {
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(text);
    }

    public void fillEmail(String text) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(text);
    }

    public void fillEdad(String text) {
        driver.findElement(edad).clear();
        driver.findElement(edad).sendKeys(text);
    }


}
