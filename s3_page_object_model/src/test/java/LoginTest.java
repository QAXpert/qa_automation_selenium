import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    LoginPage login;

    @BeforeTest
    void setup() {
        driver = WebDriverManager.chromedriver().create();
        login = new LoginPage(driver);
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test
    void testLoginSuccess() {
        login.with("user", "user");
        Assert.assertTrue(login.successBoxPresent(), "Credenciales incorrectas");

    }

    @Test
    void testLoginFailure() {
        login.with("bad-user", "bad-password");
        Assert.assertFalse(login.successBoxPresent(), "Las credenciales deberían ser incorrectas");

    }

}
