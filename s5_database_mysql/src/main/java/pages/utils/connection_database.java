package pages.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class connection_database {
    Connection con = null;
    ResultSet res;

    public void Conector() {
        try {
            String DB_URL = "jdbc:mysql://localhost:3306/qaxpert";
            String DB_USER = "root";
            String DB_PASSWORD = "root12345";

            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String dbClass = "com.mysql.cj.jdbc.Driver";
            try {
                Class.forName(dbClass);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            if (con != null) {
                System.out.println("Conectado a MySQL");
            }

        } catch (SQLException ex) {
            System.out.println("ERROR: La URL de la conexión no es válida o el usuario y clave de la BD");
            ex.printStackTrace();
        }

    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = con.createStatement();
        //System.out.println(query);
        //printResult(stmt.executeQuery(query));
        res = stmt.executeQuery(query);
        return res;

    }

    public void closeConnexion() throws SQLException {
        if (res != null) {
            res.close();
            System.out.println("ResultSet cerrado exitosamente...");
        }

        if (con != null) {
            con.close();
            System.out.println("Conexión cerrada exitosamente...");
        }
    }

    public int getColumnNumber(ResultSet res) throws SQLException {
        ResultSetMetaData rsmd = res.getMetaData();
        return rsmd.getColumnCount();

    }


    public int getRowsNumber(ResultSet res) throws SQLException {
        int filas = 0;
        while (res.next()){
            filas++;
        }
        return filas;
    }

    public void printResult(ResultSet res) throws SQLException {

        while (res.next()) {

            for (int i = 1; i <= getColumnNumber(res); i++) {
                System.out.print(" | " + res.getString(i));
                if (i == getColumnNumber(res)) {
                    System.out.println(" | " + res.getString(i));
                }
            }
        }

    }

}

