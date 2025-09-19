package Controller;
// Paquete donde está el servlet

import Dao.UsuarioDao;
import model.Usuario;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*; 
// Importaciones necesarias: DAO para acceder a la BD, el modelo Usuario,  
// librerías de Servlets y Http para manejar peticiones y respuestas.  

public class LoginServlet extends HttpServlet {
    private final UsuarioDao usuarioDao = new UsuarioDao();
    // Clase LoginServlet que extiende HttpServlet,  
    // encargada de procesar las solicitudes de inicio de sesión.  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Método doPost que se ejecuta cuando el formulario de login se envía con POST.
        String nombre_usuario = request.getParameter("nombre_usuario");  
        // Obtiene el parámetro "nombre_usuario" enviado desde el formulario.
        String contraseña = request.getParameter("contraseña");
        // Obtiene el parámetro "contraseña" enviado desde el formulario.

        Usuario u = usuarioDao.validar(nombre_usuario, contraseña);
        // Llama al método validar del DAO para comprobar si las credenciales son correctas.
        if (u != null) {
        // Si las credenciales son correctas (el usuario existe en la BD).
            HttpSession sesion = request.getSession(); 
            sesion.setAttribute("usuario", u);
            // Se guarda el objeto usuario en la sesión, para poder usarlo en otras páginas.
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
            rd.forward(request, response);
            // Redirige al usuario a la página principal (home.jsp) después del login exitoso.
        } else { 
            // Si las credenciales son incorrectas.
            request.setAttribute("errorLogin", "Usuario o contraseña incorrectos");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response); 
            // Redirige nuevamente al index.jsp (página de login), mostrando el error
        }
    }
}
