
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenTestingUsingDataBase {

    static Connection con = null;

    // Creación del object Statement
    private static Statement stmt;

    // Creación de Constantes para la conexión a la Base de Datos
    public static String DB_URL = "jdbc:mysql://localhost:3306/qaxpert";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "root12345";

    @BeforeTest
    public void setUp() throws Exception {
        try {
            // Conexión a la Base de Datos
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Statement object para enviar la declaración SQL a la base de datos
            stmt = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {

    }

    @AfterTest
    public void tearDown() {

    }

}
