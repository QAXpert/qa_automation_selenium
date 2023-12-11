package qaxpert.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandsOnPage {
    private WebDriver driver;
    private By webDriverLinkText = By.linkText("WebForm");

    public HandsOnPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnWebForm(){
        driver.findElement(webDriverLinkText).click();
    }
}
