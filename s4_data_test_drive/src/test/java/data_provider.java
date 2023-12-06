import org.testng.annotations.DataProvider;

public class data_provider {
    @DataProvider(name = "dataprovider")
    public Object[][] metodoDataProvider() {
        return new Object[][] {
                { "Maria", "Maria@yahoo.com", "23" },
                { "Diana", "Diana@gmail.com", "28" },
        };
    }
}
