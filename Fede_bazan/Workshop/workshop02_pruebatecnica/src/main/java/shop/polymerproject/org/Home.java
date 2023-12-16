package shop.polymerproject.org;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Home {

    private WebDriver driver;
    By shopNowButtonXpath = By.xpath("/html/body/shop-app//iron-pages/shop-home//div[1]/shop-button/a");
    By mensOuterwearLinkText = By.linkText("Men's Outerwear");
    By mensOuterwearCssSelector = By.cssSelector("a[href='/list/mens_outerwear']");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public SearchContext expandRootElement(WebElement element) {
        SearchContext shadowRoot = (SearchContext) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].shadowRoot", element);
        return shadowRoot;
    }

    public void clickOnASection() throws InterruptedException {
        WebElement shadowHost = driver.findElement(By.xpath("//shop-app[@page = 'home']"));
        SearchContext shadowRootZero = expandRootElement(shadowHost);
        shadowRootZero.findElement(By.cssSelector("#tabContainer > shop-tabs > shop-tab:nth-child(1) > a")).click();
    }
}
