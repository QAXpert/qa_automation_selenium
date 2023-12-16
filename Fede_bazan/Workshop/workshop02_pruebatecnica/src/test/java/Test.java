import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import shop.polymerproject.org.Home;
import shop.polymerproject.org.SectionMensOuterwear;

import java.time.Duration;

public class Test {
    WebDriver driver;
    WebDriverWait waiter;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://shop.polymer-project.org");
    }

    @AfterTest
    public  void teardown(){
        driver.quit();
    }

    @org.testng.annotations.Test
    public void testConnection(){
        Assert.assertEquals("Home - SHOP",driver.getTitle());
    }

    @org.testng.annotations.Test
    public void numberOfSection() throws InterruptedException {
        Home home = new Home(driver);
        SectionMensOuterwear sectionMensOuterwear = new SectionMensOuterwear(driver);
        home.clickOnASection();
        sectionMensOuterwear.checkMensOuterwear();
    }
}
