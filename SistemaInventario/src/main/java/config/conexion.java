package config;
// Define el paquete donde esta ubicada la clase, en este caso "config".

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Importa las classes necesarias para la conexion 


public class conexion {
// Clase "conexion" que se encargara de gestionar la conexion con la base de datos
    
    private static final String USER = "root";
    private static final String PASS = "milgar82345";
    private static final String DATABASE = "sistema_inventario";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    // Credenciales necesarias para establecer la conexion. 

    public static Connection getConection() {
        Connection cn = null;  // Variable que almacenara la conexion. 
        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            cn = DriverManager.getConnection(URL, USER, PASS);  // Se establece la conexion usando el url, usuario y contraseña. 
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver JDBC de MySQL. " + e.getMessage());
            // Si no se encuentra lanza este error.
        } catch (SQLException e) {
        }
        return cn;
        // Devuelve la conexion si es exitosa o null (si fallo) 
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
