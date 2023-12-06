// Importación de las clases necesarias para trabajar con bases de datos y TestNG
import java.sql.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Declaración de la clase principal
public class DataDrivenTestingUsingDataBase {

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

    // Método de prueba (Test) que realiza una consulta SQL y muestra los resultados
    @Test
    public void test() {
        // Definir la consulta SQL para seleccionar todos los datos de la tabla 'webform'
        String query = "SELECT * FROM webform";

        // Objeto ResultSet para almacenar los resultados de la consulta
        ResultSet res;

        try {
            // Ejecutar la consulta y obtener los resultados
            res = stmt.executeQuery(query);

            // Obtener los metadatos de los resultados para obtener información sobre las columnas
            ResultSetMetaData rsmd = res.getMetaData();

            // Obtener el número total de columnas en los resultados
            int columnsNumber = rsmd.getColumnCount();

            // Imprimir la consulta SQL en la consola
            System.out.println(query);

            // Iterar a través de cada fila en los resultados
            while (res.next()) {
                // Incrementar el contador total de filas
                total++;

                // Iterar a través de cada columna en la fila
                for (int i = 1; i <= columnsNumber; i++) {
                    // Imprimir el valor de la columna, separado por '|'
                    System.out.print(" | " + res.getString(i));

                    // Si es la última columna, imprimir una barra vertical y el valor de la columna
                    if (i == columnsNumber) {
                        System.out.println(" | " + res.getString(i));
                    }
                }
            }
        } catch (Exception e) {
            // Imprimir detalles de cualquier error que ocurra durante la ejecución de la consulta
            e.printStackTrace();
        }
    }

    // Método que se ejecuta después de las pruebas (AfterTest)
    @AfterTest
    public void tearDown() {
        // Puedes agregar acciones de limpieza o cierre aquí si es necesario
    }
}
