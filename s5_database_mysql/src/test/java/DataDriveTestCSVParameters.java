import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.WebFormPage.WebFormPage;
import pages.homePage.HomePage;

import java.io.IOException;

public class DataDriveTestCSVParameters {}
    /*private WebDriver driver;
    private HomePage homePage;
    private WebFormPage addInfo;


    @BeforeTest
    public void beforeTest() throws InterruptedException {
         WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaxpert.com/webform-lab/");
    }

    @Test
    @Parameters({"name", "email", "edad"})
    public void agregar_informacion_web_form(String name, String email, String edad) throws IOException, CsvValidationException, InterruptedException {


        homePage = new HomePage(driver);
        // Validamos que el boton de agendar asesoria este disponible
        if (homePage.isTitle()) {
            // Clck en boton de agendar asesoria
            try {
                homePage.clickButton();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        addInfo = new WebFormPage(driver);

        // Creación del objeto de tipo CSVReader


        addInfo.fillName(name);
        addInfo.fillEmail(email);
        addInfo.fillEdad(edad);
        addInfo.EnviarInformacion();
        Thread.sleep(2000);


    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    */

