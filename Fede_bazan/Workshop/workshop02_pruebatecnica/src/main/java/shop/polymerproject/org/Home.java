package shop.polymerproject.org;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Home {

    private WebDriver driver;
     By shopNowButtonLinkText = By.xpath("/html/body/shop-app//iron-pages/shop-home//div[1]/shop-button/a");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnASection() {
        driver.findElement(shopNowButtonLinkText).click();
    }
}
