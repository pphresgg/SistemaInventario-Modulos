package Controller;
// Paquete donde está el servlet.
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
// Importaciones necesarias para trabajar con servlets y manejar sesiones HTTP.  

@WebServlet("/LogoutServlet")
// Anotación que indica la URL en la que se mapea este servlet.  
// Cuando el navegador accede a "/LogoutServlet", se ejecuta este código. 
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // Método doGet que maneja peticiones GET (por ejemplo, al hacer clic en "Cerrar sesión").
        HttpSession session = request.getSession(false); // no crea nueva
        // Obtiene la sesión actual, pero con "false" evita crear una nueva si no existe.
        if (session != null) {
            session.invalidate(); // mata la sesión
        }
        
        // Redirigir al login
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        // Si la petición llega por POST, simplemente se redirige a doGet para reutilizar la lógica.  
    }
}
