package testingyes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Order {

    WebDriver driver;

    // Personal Information
    private By socialTitleRadioBtmXpath = By.xpath("//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input");
    private By firstNameLabelName = By.name("firstname");
    private By lastNameLabelName = By.name("lastname");
    private By emailLabelName = By.name("email");

    private By receiveOffersCheckXpath = By.xpath("//*[@id=\"customer-form\"]/section/div[7]/div[1]/span/label/input");
    private By signUpForNewLetCheckXpath = By.xpath("//*[@id=\"customer-form\"]/section/div[8]/div[1]/span/label/input");
    private By iAgreeTermsCheckXpath = By.xpath("//*[@id=\"customer-form\"]/section/div[9]/div[1]/span/label/input");
    private By continueBtmXpath = By.xpath("//*[@id=\"customer-form\"]/footer/button");

    //ADDRESSES information

    private By companyLabelName = By.name("company");
    private  By addressLabelName = By.name("address1");
    private By cityLabelName = By.name("city");
    
    public Order(WebDriver driver) {
        this.driver = driver;
    }

    public void completeFormPersonalInformation(String name,String lastName,String email){
        driver.findElement(firstNameLabelName).sendKeys(name);
        driver.findElement(lastNameLabelName).sendKeys(lastName);
        driver.findElement(emailLabelName).sendKeys(email);
        driver.findElement(receiveOffersCheckXpath).click();
        driver.findElement(signUpForNewLetCheckXpath).click();
        driver.findElement(iAgreeTermsCheckXpath).click();
        driver.findElement(continueBtmXpath).click();
    }

    public void completeFormAdressInformation(){

    }

}
