

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class helloWorld_DriverChrome {

    WebDriver chromeDriver;
    @BeforeTest
    public void setup() {
        // Configuración del ChromeDriver (asegúrate de tener el ejecutable en la ruta correcta)
        // Supports Chrome version 114
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome/version_114/chromedriver");
        chromeDriver = new ChromeDriver();

    }

    @AfterTest
    public void teardown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }

    }

    @Test
    public void testMultipleBrowsers() {
        // Navegando en Chrome
        String chromeUrl = "https://qaxpert.com";
        chromeDriver.get(chromeUrl);
        String chromeTitle = chromeDriver.getTitle();
        System.out.println("Title of QAXpert page in Chrome: " + chromeTitle);
        // Agrega assertions u otras acciones según sea necesario


    }
}
