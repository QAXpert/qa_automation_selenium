package qaxpert.com;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandsOnWebFormPage {
    private WebDriver driver;
    private By nameLabelFormId = By.id("nombre");
    private By mailLabelFormId =By.id("email");
    private By ageLabelFormId = By.id("edad");
    private By sendBtmForm = By.xpath("//*[@id=\"surveyForm\"]/div[8]/button");

    public HandsOnWebFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void completeForm(String name,String email,int edad){
        driver.findElement(nameLabelFormId).sendKeys(name);
        driver.findElement(mailLabelFormId).sendKeys(email);
        driver.findElement(ageLabelFormId).sendKeys(String.valueOf(edad));
        driver.findElement(sendBtmForm).click();
        driver.switchTo().alert().accept();
    }
}
