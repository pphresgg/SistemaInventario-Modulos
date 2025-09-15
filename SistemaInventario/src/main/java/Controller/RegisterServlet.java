package Controller;

import Dao.UsuarioDao;
import model.Usuario;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RegisterServlet extends jakarta.servlet.http.HttpServlet {
    private final UsuarioDao usuarioDao = new UsuarioDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario u = new Usuario();
        u.setNombre(request.getParameter("nombre"));
        u.setApellido(request.getParameter("apellido"));
        u.setCorreo(request.getParameter("correo"));
        u.setNombre_usuario(request.getParameter("nombre_usuario"));
        u.setContraseña(request.getParameter("contraseña"));
        u.setRol("empleado");

if (usuarioDao.registrar(u)) {
    request.getSession().setAttribute("registroStatus", "ok");
} else {
    request.getSession().setAttribute("registroStatus", "error");
}
response.sendRedirect("index.jsp");

    }
}
