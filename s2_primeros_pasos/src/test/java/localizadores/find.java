package localizadores;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.List;

public class find {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String filePath = Paths.get("src", "main", "resources", "qaxpertHome.html").toAbsolutePath().toString();
        driver.get("file:///" + filePath);
        driver.manage().window().maximize();
    }

    @Test
    public void localizarElementos() {
        // Localiza elementos utilizando diferentes tipos de localizadores

        // By.id
        WebElement elementoId = driver.findElement(By.id("titulo"));
        System.out.println("Texto del elemento con id 'titulo': " + elementoId.getText());
        List<WebElement> elements =  driver.findElements(By.tagName("input"));
       for (WebElement element : elements){
           element.sendKeys("texto");
       }
        System.out.println("Texto del elementos con id 'titulo': " );
    }

}
