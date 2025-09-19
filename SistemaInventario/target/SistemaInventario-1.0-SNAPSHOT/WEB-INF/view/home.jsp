<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Usuario" %>
<%
    // Recuperamos el objeto "usuario" de la sesión
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    // Si no hay usuario en sesión, redirige al login (seguridad básica)
    if (usuario == null) {
        response.sendRedirect(request.getContextPath() + "/index.html");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel Inventario</title>
</head>
<body>
    <!-- Mostramos el nombre y apellido del usuario logueado -->
    <h1>Bienvenido, <%= usuario.getNombre() %> <%= usuario.getApellido() %>!</h1>
    <p>Usuario: <%= usuario.getNombre_usuario() %></p>
    <p>Rol: <%= usuario.getRol() %></p>
    <!-- Enlace para cerrar sesión -->
    <a href="<%= request.getContextPath() %>/LogoutServlet">Cerrar sesión</a>
</body>
</html>
