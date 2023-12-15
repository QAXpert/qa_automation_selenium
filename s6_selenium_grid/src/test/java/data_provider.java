
import java.sql.ResultSet;

import org.testng.annotations.DataProvider;
import pages.utils.connection_database;

public class data_provider {

    @DataProvider(name = "MySQL_dataprovider")
    public Object[][] mySQL_Data() {

        int rowCount = 0;
        int columnCount = 0;
        String myData[][] = null;
        connection_database conect = new connection_database();
        ResultSet res;

        try {
            conect.Conector();

            // Ejecutar consulta (query) a la BD
            String query = "SELECT * FROM webform";
            res = conect.executeQuery(query);

            // Obtener nro de filas y columnas
            columnCount = conect.getColumnNumber(res);
            rowCount = conect.getRowsNumber(res);

            System.out.println("Columnas : " + columnCount);
            System.out.println("Filas : " + rowCount);

            // Inicializar la matriz
            myData = new String[rowCount][columnCount];
            res = conect.executeQuery(query);

            // Llenar la matriz con el resultado de la consulta MySQL
            for(int row=0; row<rowCount; row++)
            {
                res.next();

                for(int col=1; col<=columnCount; col++)
                    myData[row][col-1] = res.getString(col);
            }

            //Cerrar la conexión
            conect.closeConnexion();

        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return myData;

    }

}
