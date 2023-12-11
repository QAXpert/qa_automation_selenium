import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import qaxpert.com.HandsOnPage;
import qaxpert.com.HandsOnWebFormPage;
import qaxpert.com.Home;

public class Test {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qaxpert.com");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    public void connectionTest(){
        Assert.assertEquals(driver.getTitle(),"QaXpert | Ninja For Testing");
    }

    @org.testng.annotations.Test
    public void completeForm(){
        Home home = new Home(driver);
        HandsOnPage handsOnPage = new HandsOnPage(driver);
        HandsOnWebFormPage handsOnWebFormPage = new HandsOnWebFormPage(driver);
        home.clickOnHandsOn();
        handsOnPage.clickOnWebForm();
        handsOnWebFormPage.completeForm("fede","fede@elfedemasfede.com",31);
    }
}
