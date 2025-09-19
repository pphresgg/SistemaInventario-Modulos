package Dao;
// Paquete donde se maneja la lógica de acceso a datos

import config.conexion;
import model.Usuario;
import java.sql.*;
// Importaciones: conexión a la BD, el modelo Usuario, y librerías de JDBC para consultas SQL
public class UsuarioDao {
    // Clase UsuarioDao: contiene métodos para interactuar con la tabla "usuarios" en la BD

    public Usuario validar(String nombre_usuario, String contraseña) {
        // Método para validar el login de un usuario.
        // Recibe nombre_usuario y contraseña, y devuelve un objeto Usuario si las credenciales son correctas.  
        
        Usuario u = null; // Inicialmente, el usuario es null (no encontrado).
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario=? AND contraseña=?"; 
        // Consulta SQL que busca un usuario con el nombre y la contraseña ingresados
        // Los "?" se reemplazan con valores usando PreparedStatement (previene SQL Injection).
        try (Connection cn = conexion.getConection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre_usuario);
            ps.setString(2, contraseña); // Se asignan los valores del usuario y contraseña a la consulta SQL.
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) { // Si existe un registro que coincide, se crea un objeto Usuario.  
                    u = new Usuario();
                    u.setId_usuario(rs.getInt("id_usuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellido(rs.getString("apellido"));
                    u.setCorreo(rs.getString("correo"));
                    u.setNombre_usuario(rs.getString("nombre_usuario"));
                    u.setContraseña(rs.getString("contraseña"));
                    u.setRol(rs.getString("rol")); 
                    // Se asignan todos los valores obtenidos de la base de datos al objeto Usuario. 
                }
            }
        } catch (Exception e) {
            System.out.println("Error validar usuario: " + e.getMessage());
            // En caso de error (ej. conexión fallida), se muestra el mensaje.
        }
        return u; // Retorna el objeto Usuario (si lo encontró) o null (si no encontró coincidencia).
    }

    public boolean registrar(Usuario u) {
        // Método para registrar un nuevo usuario en la BD.  
        // Devuelve true si el registro fue exitoso, false si hubo error.
        String sql = "INSERT INTO usuarios (nombre, apellido, correo, nombre_usuario, contraseña, rol) VALUES (?,?,?,?,?,?)";
        try (Connection cn = conexion.getConection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellido());
            ps.setString(3, u.getCorreo());
            ps.setString(4, u.getNombre_usuario());
            ps.setString(5, u.getContraseña());
            ps.setString(6, (u.getRol() == null ? "empleado" : u.getRol()));
            ps.executeUpdate(); 
            // Se asignan los valores desde el objeto Usuario a la consulta.  
            // Si el rol es null, se asigna por defecto "empleado".  
            return true;
        } catch (SQLException e) {
            System.out.println("Error registrar usuario: " + e.getMessage());
            // En caso de error (ej. violación de clave única, error de conexión, etc.).
            return false;
        }
    }
}
