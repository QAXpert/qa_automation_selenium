package testingyes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    private  By zipCodeLabelName = By.name("postcode");
    private By continuneBtmAddressName = By.name("confirm-addresses");

    //Delivery Space
    private By deliveryCommentId = By.id("delivery_message");
    private By continueDeliveryBtmName = By.name("confirmDeliveryOption");

    //Payment

    private By payamentOpc1Id = By.id("payment-option-1");
    private By termAndCondCheckId = By.id("conditions_to_approve[terms-and-conditions]");
    private By continuePaymentBtmClass = By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button");
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

    public void completeFormAdressInformation(String company, String address,String city,String zcode){
        WebElement stateSelected = driver.findElement(By.name("id_state"));
        Select selectState = new Select(stateSelected);
        WebElement countrySelected = driver.findElement(By.name("id_country"));
        Select selectCountry = new Select(countrySelected);
        driver.findElement(companyLabelName).sendKeys(company);
        driver.findElement(addressLabelName).sendKeys(address);
        driver.findElement(cityLabelName).sendKeys(city);
        selectState.selectByValue("4");
        selectCountry.selectByValue("21");
        driver.findElement(zipCodeLabelName).sendKeys(zcode);
        driver.findElement(continuneBtmAddressName).click();
    }

    public void completeDeliveryComment(String deliveryMsg){
        driver.findElement(deliveryCommentId).sendKeys(deliveryMsg);
        driver.findElement(continueDeliveryBtmName).click();
    }

    public void completePayment() throws InterruptedException {
        driver.findElement(payamentOpc1Id).click();
        Thread.sleep(3000);
        driver.findElement(termAndCondCheckId).click();
        driver.findElement(continuePaymentBtmClass).click();
    }
}
