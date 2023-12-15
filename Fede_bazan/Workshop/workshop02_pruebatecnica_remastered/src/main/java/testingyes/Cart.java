package testingyes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

    WebDriver driver;

    By sectionArticleClass = By.className("cart-item");

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public boolean  addedCheclArticle(){
        return driver.findElement(sectionArticleClass).isDisplayed();
    }
}
