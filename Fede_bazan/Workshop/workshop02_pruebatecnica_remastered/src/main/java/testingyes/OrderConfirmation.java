package testingyes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmation extends Base {

    WebDriver driver;

    private By msgConfirmOrderClassName = (By) driver.findElement(By.className("h1 card-title"));
    public OrderConfirmation(WebDriver driver) {
        super(driver);
    }

    public String checkBuyMsg(){
        return getText(msgConfirmOrderClassName);
    }

}
