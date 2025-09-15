package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    private static final String USER = "root";
    private static final String PASS = "milgar82345";
    private static final String DATABASE = "sistema_inventario";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;

    public static Connection getConection() {
        Connection cn = null;
        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            cn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC de MySQL. " + e.getMessage());
        } catch (SQLException e) {
        }
        return cn;
    }

    public static void main(String[] args) {
        Connection conn = getConection();
        if (conn != null) {
            System.out.println("Conexión establecida correctamente.");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
