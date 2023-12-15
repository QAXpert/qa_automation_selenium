import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.WebFormPage.WebFormPage;
import pages.homePage.HomePage;

public class CrossBrowserTestingScriptWithDriver {

    private WebDriver driver;
    private HomePage homePage;
    private WebFormPage addInfo;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("-------- INICIO DE LA EJECUCIÓN DE PRUEBAS CON MULTIPLES NAVEGADORES ------------");
        System.out.println("---------------------------------------------------------------------------------");
    }

    @BeforeTest
    @Parameters({ "browser", "driver_name", "driver_path" })
    public void beforeTest(String browser, String driver_name, String driver_path) throws Exception{

        System.setProperty(driver_name, driver_path);

        if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("Safari")){
            driver = new SafariDriver();
        }
        else {
            throw new Exception("Navegador no parametrizado...");
        }
    }

}
