package Controller;

import Dao.UsuarioDao;
import model.Usuario;
import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    private final UsuarioDao usuarioDao = new UsuarioDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nombre_usuario = request.getParameter("nombre_usuario");
        String contraseña = request.getParameter("contraseña");

        Usuario u = usuarioDao.validar(nombre_usuario, contraseña);

        if (u != null) {

            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", u);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("errorLogin", "Usuario o contraseña incorrectos");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
