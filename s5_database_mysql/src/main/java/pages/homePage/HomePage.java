package pages.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    protected WebDriver driver;

    // Definimos objetos de tipo locator y le asignamos la localización By.
    private By h1_title = By.xpath("//h1");


    // Creamos el método que recibirá el driver en esta clase
    public HomePage(WebDriver driver){
        this.driver = driver;

        // Recuerdas la clase anterior de manejo de errores? bueno en este código hacemos una validación para asegurarnos que estemos en la homePage, validando que el título de la página sea la de bedu, si no lo es, se lanza una excepción y se devuelve la url de la página actual.
        if (!driver.getCurrentUrl().equals("https://qaxpert.com/webform-lab/")) {
            throw new IllegalStateException("Error, no se recibió la página Home de QAX, la página recibida es: " + driver.getCurrentUrl());
        }

    }

    //Creamos el método validara si el botón esta disponible
    public boolean isTitle() {
        System.out.println("El titulo de form es visible : " + driver.findElement(h1_title).isDisplayed());
        return driver.findElement(h1_title).isDisplayed();
    }

    //Creamos el método que realizara click en el botón
    public void clickButton() throws InterruptedException {
        driver.findElement(h1_title).click();
        Thread.sleep(1000);
    }
}
