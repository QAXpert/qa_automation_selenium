import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import testingyes.Article;
import testingyes.Cart;
import testingyes.Home;

public class Test {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.testingyes.com/onlineshop/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @org.testng.annotations.Test
    public void testConnection(){
        Home home = new Home(driver);
        Assert.isTrue(home.IsDisplayedheader().isDisplayed(), String.valueOf(true));
    }

    //Ver articulo
    @org.testng.annotations.Test
    public void watchElement(){
        Home home = new Home(driver);
        Article article = new Article(driver);
        home.watchTheElement();
        article.checkImgElement();
    }

    //Agregar al carrito
    @org.testng.annotations.Test
    public void addArticle() throws InterruptedException {
        String expectedMsg= "\uE876Product successfully added to your shopping cart";
        watchElement();
        Article article = new Article(driver);
        String actualMsg=article.clickOnAddAndCheckToCart();
        org.testng.Assert.assertEquals(actualMsg,expectedMsg);
    }

    //Ver el carro de compras
    @org.testng.annotations.Test
    public void watchCart() throws InterruptedException {
        addArticle();
        Article article = new Article(driver);
        Cart cart = new Cart(driver);
        article.clickOnBtmProceedToCheckOut();
        org.testng.Assert.assertTrue(cart.addedCheclArticle());
    }

    public void
}

