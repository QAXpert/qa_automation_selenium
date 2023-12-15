import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.WebFormPage.WebFormPage;
import pages.homePage.HomePage;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {

    private WebDriver driver;
    private HomePage homePage;
    private WebFormPage addInfo;
    String baseURL = "https://qaxpert.com/webform-lab/";
    String nodeURL = "http://192.168.101.76:4444";


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("-------   INICIO DE LA EJECUCIÓN DE PRUEBAS CON FIREFOX DE FORMA REMOTA ---------");
        System.out.println("---------------------------------------------------------------------------------");
    }


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        //Seteamos la propiedad del sistema para firefox
        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
        //creamos el objeto DesiredCapabilities
        DesiredCapabilities capability = new DesiredCapabilities();
        // le configuramos el navegador y la plataforma
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.MAC);
        // asignamos el RemoteWebDriver enviadole el objeto capability y la nodeURL
        driver = new RemoteWebDriver(new URL(nodeURL), capability);

    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(baseURL);
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

    @AfterTest
    public void afterTest() {

        //si el driver existe lo cierra
        if (driver != null) {
            driver.quit();
        }
    }


    @AfterSuite
    public void afterSuite() {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("---------------     FIN DE LA EJECUCIÓN DE LA SUITE     -------------------------");
        System.out.println("---------------------------------------------------------------------------------");
    }

}
