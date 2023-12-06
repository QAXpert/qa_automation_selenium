import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.WebFormPage.WebFormPage;
import pages.homePage.HomePage;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class DataDriveTestCSV {
    private WebDriver driver;
    private HomePage homePage;
    private WebFormPage addInfo;

    // Indicar la ubicación del archivo csv
    String filePath = Paths.get("src", "test", "resources", "user.csv").toAbsolutePath().toString();
    private CSVReader csvReader;
    // Declaración de una variable para leer los datos del csv
    String[] csvCell;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
         WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qaxpert.com/webform-lab/");
    }

    @Test
    public void agregar_informacion_web_form() throws IOException, CsvValidationException, InterruptedException {


        homePage = new HomePage(driver);
        if (homePage.isTitle()) {
            try {
                homePage.clickButton();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        addInfo = new WebFormPage(driver);

        // Creación del objeto de tipo CSVReader
        csvReader = new CSVReader(new FileReader(filePath));

        // uso de un loop para la lectura de todos los datos del csv
        while ((csvCell = csvReader.readNext()) != null) {

            addInfo.fillName(csvCell[0]);
            addInfo.fillEmail(csvCell[1]);
            addInfo.fillEdad(csvCell[2]);
            addInfo.EnviarInformacion();
            //click alert
            Thread.sleep(2000);
        }

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

}
