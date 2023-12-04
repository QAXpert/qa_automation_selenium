

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class helloWorld_DriverFirefox {

    WebDriver chromeDriver;
    WebDriver firefoxDriver;

    @BeforeMethod
    public void setup() {


        // Configuración del GeckoDriver (Firefox) (asegúrate de tener el ejecutable en la ruta correcta)
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver/version_0.33/geckodriver");
        firefoxDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void teardown() {

        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
    }

    @Test
    public void testMultipleBrowsers() {
        // Navegando en Firefox
        String firefoxUrl = "https://qaxpert.com";
        firefoxDriver.get(firefoxUrl);
        String firefoxTitle = firefoxDriver.getTitle();
        System.out.println("Title of QAXpert page in Firefox: " + firefoxTitle);
        // Agrega assertions u otras acciones según sea necesario
    }
}
