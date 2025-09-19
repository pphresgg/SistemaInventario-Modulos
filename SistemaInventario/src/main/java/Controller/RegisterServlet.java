package Controller;
// Paquete donde está el servlet 

import Dao.UsuarioDao;
import model.Usuario;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
// Importaciones necesarias: DAO para interacción con la base de datos,  
// el modelo Usuario, y librerías de servlets/HTTP.  

public class RegisterServlet extends jakarta.servlet.http.HttpServlet {
    // Clase RegisterServlet que extiende HttpServlet.  
    // Se encarga de recibir los datos de registro desde un formulario y guardarlos en la BD.
    private final UsuarioDao usuarioDao = new UsuarioDao();
    // Se instancia UsuarioDao para manejar la lógica de acceso a datos (insertar usuario en la BD).  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario u = new Usuario();
        // Método doPost: se ejecuta cuando el formulario de registro se envía con POST.
        u.setNombre(request.getParameter("nombre"));
        u.setApellido(request.getParameter("apellido"));
        u.setCorreo(request.getParameter("correo"));
        u.setNombre_usuario(request.getParameter("nombre_usuario"));
        u.setContraseña(request.getParameter("contraseña"));
        // Se obtienen los campos de las credenciales para asignarlas al objeto Usuario.
        u.setRol("empleado");
        // Se asigna un rol por defecto al nuevo usuario (ejemplo: "empleado").
        
 
if (usuarioDao.registrar(u)) {
    request.getSession().setAttribute("registroStatus", "ok");
    // Llama al método registrar del DAO.  
    // Devuelve true si el usuario se insertó correctamente en la base de datos.
} else {
    request.getSession().setAttribute("registroStatus", "error");
    // Si falló, se guarda en la sesión un estado "error".
}
response.sendRedirect("index.jsp"); // Después de registrar (o intentar registrar), se redirige al login (index.jsp).

    }
}
