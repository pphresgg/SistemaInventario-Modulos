package model; 
// Define el paquete donde esta ubicada esta clase, en este caso "model" 

public class Usuario {
    // Clase "Usuario" que representa la entidad usuario dentro del sistema.  

    private int id_usuario; // Identificador único del usuario
    private String nombre; // Nombre del usuario.
    private String apellido; // Apellido del usuario.
    private String correo; // Correo electrónico del usuario
    private String nombre_usuario; // Nombre de usuario
    private String contraseña; // Contraseña del usuario para acceder al sistema. 
    private String rol; // Rol que tiene el usuario en el sistema

    public Usuario() {}
    // Constructor vacío. Es necesario para poder crear objetos Usuario sin parámetros.
    // Getters y Setters
    // Métodos que permiten acceder y modificar los atributos privados de la clase. 
    public int getId_usuario() { return id_usuario; }
    public void setId_usuario(int id_usuario) { this.id_usuario = id_usuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getNombre_usuario() { return nombre_usuario; }
    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }

    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
