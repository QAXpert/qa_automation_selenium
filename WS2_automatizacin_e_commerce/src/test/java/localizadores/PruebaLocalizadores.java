package localizadores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class PruebaLocalizadores {

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
    public void localizarElementos() {
        // Localiza elementos utilizando diferentes tipos de localizadores

        // By.id
        WebElement elementoId = driver.findElement(By.id("titulo"));
        System.out.println("Texto del elemento con id 'titulo': " + elementoId.getText());

        // By.name
        WebElement elementoName = driver.findElement(By.name("username"));
        System.out.println("Atributo value del elemento con name 'username': " + elementoName.getAttribute("value"));

        // By.className
        WebElement elementoClassName = driver.findElement(By.className("submit-button"));
        System.out.println("Texto del elemento con clase 'submit-button': " + elementoClassName.getText());

        // By.tagName
        WebElement elementoTagName = driver.findElement(By.tagName("a"));
        System.out.println("Texto del primer enlace encontrado: " + elementoTagName.getText());

        // By.linkText
        WebElement elementoLinkText = driver.findElement(By.linkText("Ir a Casa"));
        System.out.println("Texto del enlace con link text 'Ir a Casa': " + elementoLinkText.getText());

        // By.partialLinkText
        WebElement elementoPartialLinkText = driver.findElement(By.partialLinkText("Nosotros"));
        System.out.println("Texto del enlace con partial link text 'Nosotros': " + elementoPartialLinkText.getText());

        // By.cssSelector
        WebElement elementoCssSelector = driver.findElement(By.cssSelector("input[name='username']"));
        System.out.println("Atributo value del elemento con CSS Selector 'input[name='username']': " + elementoCssSelector.getAttribute("value"));

        // By.xpath
        WebElement elementoXPath = driver.findElement(By.xpath("//input[@type='submit']"));
        System.out.println("Atributo value del elemento con XPath '//input[@type='submit']': " + elementoXPath.getAttribute("value"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
