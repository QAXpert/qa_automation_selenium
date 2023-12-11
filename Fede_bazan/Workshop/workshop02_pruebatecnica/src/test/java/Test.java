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
    }

    @AfterTest
    public  void teardown(){
        driver.quit();
    }

    @org.testng.annotations.Test
    public void connection(){
        driver.get("https://shop.polymer-project.org");
        Assert.assertEquals("Home - SHOP",driver.getTitle());
    }

    @org.testng.annotations.Test
    public void numberOfSection(){
        Home home = new Home(driver);
        SectionMensOuterwear sectionMensOuterwear = new SectionMensOuterwear(driver);
        home.clickOnASection();
        sectionMensOuterwear.checkMensOuterwear();
    }
}
