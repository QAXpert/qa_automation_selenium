package qaxpert.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private WebDriver driver;
    private By handsOnBtmLinkText = By.linkText("Hands-On");
    private By handsOnBtomXpath = By.xpath("//*[@id=\"menu-item-2003\"]/a");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnHandsOn(){
        driver.findElement(handsOnBtomXpath).click();
    }
}
