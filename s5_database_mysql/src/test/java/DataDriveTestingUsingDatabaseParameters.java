
        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;
        import pages.WebFormPage.WebFormPage;
        import pages.homePage.HomePage;

        public class DataDriveTestingUsingDatabaseParameters {

    private WebDriver driver;
    private HomePage homePage;
    private WebFormPage addInfo;

    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaxpert.com/webform-lab/");
    }

    @Test(dataProvider = "MySQL_dataprovider", dataProviderClass = data_provider.class)
    public void webForm(String name, String email, String edad) throws InterruptedException {

        homePage = new HomePage(driver);
        if (homePage.isTitle()) {
            // Clck en boton de agendar asesoria
            try {
                homePage.clickButton();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        addInfo = new WebFormPage(driver);

        if (homePage.isTitle()) {

            addInfo.fillName(name);
            addInfo.fillEmail(email);
            addInfo.fillEdad(edad);
            addInfo.EnviarInformacion();
            Thread.sleep(2000);
        }

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}
