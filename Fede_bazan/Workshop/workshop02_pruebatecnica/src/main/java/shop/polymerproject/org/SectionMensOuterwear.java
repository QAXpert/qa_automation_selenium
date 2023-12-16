package shop.polymerproject.org;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SectionMensOuterwear {
    WebDriver driver;

    By tittleXpath = By.xpath("/html/body/shop-app//iron-pages/shop-list//header/h1");

    public SectionMensOuterwear(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkMensOuterwear() {
        Home home = new Home(driver);
        WebElement shadowHost = driver.findElement(By.xpath("//shop-app[@page = 'list']"));
        SearchContext shadowRootZero = home.expandRootElement(shadowHost);
        WebElement shadowRoot1 = shadowRootZero.findElement(By.cssSelector("iron-pages > shop-list"));
        SearchContext shadowRootOne = home.expandRootElement(shadowRoot1);
        return shadowRootOne.findElement(By.cssSelector("ul")).isDisplayed();
    }


}
