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

    public void clickOnASection() {
        WebElement bloque1=driver.findElement(By.cssSelector("shop-app[page=\"list\"]"));
        SearchContext context = bloque1.getShadowRoot();

        WebElement bloque2= (WebElement) context.findElements(By.cssSelector("app-header#header"));
        SearchContext context1 = bloque2.getShadowRoot();

        WebElement bloque3= context1.findElement(By.cssSelector("shop-tabs[attr-for-selected=\"name\"]"));
        SearchContext context2 = bloque3.getShadowRoot();

        WebElement bloque4=context2.findElement(By.cssSelector("shop-tabs[attr-for-selected=\"name\"] shop-tab:first-child\n"));
        SearchContext context3 = bloque4.getShadowRoot();

        WebElement bloque5=context3.findElement(By.cssSelector("shop-tabs[attr-for-selected=\"name\"] shop-tab.iron-selected\n"));
        SearchContext context4 = bloque5.getShadowRoot();

        driver.findElement(mensOuterwearCssSelector).click();

    }

    public void attempt2clickOnASection(){

    }
}
