// Importación de las anotaciones de TestNG y las clases relacionadas con JDBC
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.*;

// Declaración de la clase principal
public class ProcesarResultados {

    // Declaración de una variable de conexión a la base de datos
    static Connection con = null;

    // Declaración de una variable para contar el total de filas procesadas
    int total = 0;

    // Creación del objeto Statement para ejecutar consultas SQL
    private static Statement stmt;

    // Declaración de constantes para la conexión a la base de datos
    public static String DB_URL = "jdbc:mysql://localhost:3306/qaxpert";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "root12345";

    // Método que se ejecuta antes de las pruebas (BeforeTest)
    @BeforeTest
    public void setUp() throws Exception {
        try {
            // Conexión a la Base de Datos
            String dbClass = "com.mysql.cj.jdbc.Driver";

            // Cargar el controlador JDBC para MySQL
            Class.forName(dbClass);

            // Establecer la conexión a la base de datos
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Crear un objeto Statement para enviar consultas SQL a la base de datos
            stmt = con.createStatement();

        } catch (Exception e) {
            // Imprimir detalles de cualquier error que ocurra durante la conexión
            e.printStackTrace();
        }
    }

    // Método de prueba principal
    @Test
    public void test() {
        // Consulta SQL para seleccionar todos los registros de la tabla 'webform'
        String query = "SELECT * FROM webform";
        ResultSet res;
        try {
            // Ejecutar la consulta y obtener el conjunto de resultados
            res = stmt.executeQuery(query);

            // Obtener la información sobre los metadatos del conjunto de resultados
            ResultSetMetaData rsmd = res.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // Imprimir la consulta SQL
            System.out.println(query);

            // Iterar a través de los resultados y mostrar cada columna
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
            // Manejar excepciones e imprimir detalles en caso de error
            e.printStackTrace();
        }
    }

    // Método de prueba que procesa los resultados usando getString()
    @Test
    public void testProcesarResultados() {
        try {
            // Consulta SQL para seleccionar registros de 'webform' donde la edad es mayor a 28
            String query = "SELECT * FROM webform WHERE edad > 88";
            ResultSet res = stmt.executeQuery(query);

            // Obtener información sobre los metadatos del conjunto de resultados
            ResultSetMetaData rsmd = res.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            // Imprimir la consulta SQL
            System.out.println(query);

            // Iterar a través de los resultados y mostrar información específica usando getString()
            while (res.next()) {
                total++;
                System.out.println("Nombre: " + res.getString("name") + " | Edad: " + res.getString("edad"));
            }
        } catch (Exception e) {
            // Manejar excepciones e imprimir detalles en caso de error
            e.printStackTrace();
        }
    }

    // Método de prueba adicional para demostrar otro caso de uso usando getString()
    @Test
    public void testProcesarResultadosOtroCaso() {
        try {
            // Consulta SQL para seleccionar registros de 'webform' donde el email es 'juan@example.com'
            String query = "SELECT * FROM webform WHERE email = 'juan@example.com'";
            ResultSet res = stmt.executeQuery(query);

            // Imprimir la consulta SQL
            System.out.println(query);

            // Iterar a través de los resultados y mostrar información específica usando getString()
            while (res.next()) {
                total++;
                System.out.println("Nombre: " + res.getString("name") +
                        " | Email: " + res.getString("email") +
                        " | Edad: " + res.getString("edad"));
            }
        } catch (Exception e) {
            // Manejar excepciones e imprimir detalles en caso de error
            e.printStackTrace();
        }
    }

    // Método que se ejecuta después de las pruebas (AfterTest)
    @AfterTest
    public void tearDown() {
        // Puedes realizar cualquier limpieza necesaria aquí
    }
}
