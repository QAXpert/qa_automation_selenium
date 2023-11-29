import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class helloWorldChrome {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testQAXpertPage() {
        // Exercise
        String qaxpertUrl = "https://qaxpert.com";
        driver.get(qaxpertUrl);
        String title = driver.getTitle();
        System.out.println("Title of QAXpert page: " + title);
        // Add assertions or further actions as needed
    }
}
