package waits;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alert {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");

    }


    @Test
    public void manejoDeAlerta() {
        // Hacer clic en el botón que lanza el alert
        WebElement launchAlertButton = driver.findElement(By.id("my-alert"));
        launchAlertButton.click();

        // Esperar a que aparezca la alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Expected");

    }

    @AfterTest
    public void tearDown() {
        // Cerrar el navegador al finalizar la prueba
        driver.quit();
    }
}
