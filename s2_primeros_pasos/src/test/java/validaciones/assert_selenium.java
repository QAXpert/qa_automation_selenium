package validaciones;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.nio.file.Paths;
public class assert_selenium {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Obtén la ruta relativa desde la ubicación actual del script
        String filePath = Paths.get("src", "main", "resources", "qaxpertHome.html").toAbsolutePath().toString();
        // Abre la página de prueba
        driver.get("file:///" + filePath);
        driver.manage().window().maximize();
    }

    @Test
    public void localizarElementosHard() {
        // Localiza elementos utilizando diferentes tipos de localizadores

        // By.id
        WebElement elementoId = driver.findElement(By.id("titulo"));
        Assert.assertEquals(elementoId.getText(), "Texto Esperado para el elemento con id 'titulo'");

        // By.name
        WebElement elementoName = driver.findElement(By.name("username"));
        Assert.assertEquals(elementoName.getAttribute("value"), "ValorEsperado", "El valor del atributo 'value' no coincide");

        // By.className
        WebElement elementoClassName = driver.findElement(By.className("submit-button"));
        Assert.assertTrue(elementoClassName.isDisplayed(), "El elemento con clase 'submit-button' no está visible");

        // ... (Agrega más aserciones según tus necesidades)
    }

    @Test
    public void localizarElementosSoft() {
        SoftAssert softAssert = new SoftAssert();

        // By.id
        WebElement elementoId = driver.findElement(By.id("titulo"));
        softAssert.assertEquals(elementoId.getText(), "Testing Web");

        // By.name
        WebElement elementoName = driver.findElement(By.name("username"));
        softAssert.assertEquals(elementoName.getAttribute("type"), "text", "El valor del atributo 'value' no coincide");

        // By.className
        WebElement elementoClassName = driver.findElement(By.className("submit-button"));
        softAssert.assertTrue(elementoClassName.isDisplayed(), "El elemento con clase 'submit-button' no está visible");

        softAssert.assertAll();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
