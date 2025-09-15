package Dao;

import config.conexion;
import model.Usuario;
import java.sql.*;

public class UsuarioDao {

    public Usuario validar(String nombre_usuario, String contraseña) {
        Usuario u = null;
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario=? AND contraseña=?";
        try (Connection cn = conexion.getConection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre_usuario);
            ps.setString(2, contraseña);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    u = new Usuario();
                    u.setId_usuario(rs.getInt("id_usuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setApellido(rs.getString("apellido"));
                    u.setCorreo(rs.getString("correo"));
                    u.setNombre_usuario(rs.getString("nombre_usuario"));
                    u.setContraseña(rs.getString("contraseña"));
                    u.setRol(rs.getString("rol"));
                }
            }
        } catch (Exception e) {
            System.out.println("Error validar usuario: " + e.getMessage());
        }
        return u;
    }

    public boolean registrar(Usuario u) {
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
            return true;
        } catch (SQLException e) {
            System.out.println("Error registrar usuario: " + e.getMessage());
            return false;
        }
    }
}
