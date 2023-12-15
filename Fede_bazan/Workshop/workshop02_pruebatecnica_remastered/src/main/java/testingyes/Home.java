package testingyes;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {

    WebDriver driver;

    By headerElementID = By.id("header");
    By elementImgXpath = By.xpath("//*[@id=\"content\"]/section/div/article[1]/div/a/img");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement IsDisplayedheader(){
        return driver.findElement(headerElementID);
    }

    public void watchTheElement(){
        driver.findElement(elementImgXpath).click();
    }

}
