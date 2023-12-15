
import static org.testng.Assert.assertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demo {
    int total = 0;
    // Creación del object de conexión
    static Connection con = null;

    // Creación del object Statement
    private static Statement stmt;
    private ResultSet res;

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
    @Parameters({"query"})
    public void test(String query) {

        try {

            // Definir y ejecutar la consulta a la base de datos
            res = stmt.executeQuery(query);

            // objeto ResultSetMetaData para obtener el numero de columnas de la tabla
            ResultSetMetaData rsmd = res.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            System.out.println(query);

            while (res.next()) {

                total++;

                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(" | " + res.getString(i));
                    if (i == columnsNumber) {
                        System.out.println(" | " + res.getString(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // asersiones
        assertTrue(total >= 1, "No se obtuvieron resultados de la consulta");

    }

    @AfterTest
    public void tearDown() throws Exception {
        if (res != null){
            res.close();
        }
        // Cerrar la conexión a la base de datos
        if (con != null) {
            con.close();
        }

    }

}
