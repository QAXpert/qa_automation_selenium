package shop.polymerproject.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SectionMensOuterwear {
    WebDriver driver;

    By tittleXpath = By.xpath("/html/body/shop-app//iron-pages/shop-list//header/h1");

    public SectionMensOuterwear(WebDriver driver) {
        this.driver = driver;
    }

    public void checkMensOuterwear() {
        String tittleText=driver.findElement(tittleXpath).getText();
        Assert.assertEquals("Men's Outerwear",tittleText);
    }


}
