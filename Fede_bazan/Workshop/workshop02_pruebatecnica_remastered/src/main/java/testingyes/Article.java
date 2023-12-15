package testingyes;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Article {

    WebDriver driver;

    By sectionPageArticleId = By.id("content");
    By addToCartBtmClass = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    By msgSuccessfullAddId = By.id("myModalLabel");

    By proceedToCheckOutBtmLinkText = By.linkText("\uE876Proceed to checkout");
    By proceedToCheckOutBtmXpath = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public Article(WebDriver driver) {
        this.driver = driver;
    }

    public void checkImgElement(){
        Assert.isTrue(driver.findElement(sectionPageArticleId).isDisplayed(),"El elemento no se muestra");
    }

    public String clickOnAddAndCheckToCart() throws InterruptedException {
        driver.findElement(addToCartBtmClass).click();
        Thread.sleep(5000); //ver otra forma MALA PRACTICA
        String actualMsg = driver.findElement(msgSuccessfullAddId).getText();
        return actualMsg;
    }

    public void clickOnBtmProceedToCheckOut(){
        driver.findElement(proceedToCheckOutBtmXpath).click();
    }

}
