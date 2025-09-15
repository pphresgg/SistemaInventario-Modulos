<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Usuario" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
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
    <h1>Bienvenido, <%= usuario.getNombre() %> <%= usuario.getApellido() %>!</h1>
    <p>Usuario: <%= usuario.getNombre_usuario() %></p>
    <p>Rol: <%= usuario.getRol() %></p>

    <a href="<%= request.getContextPath() %>/LogoutServlet">Cerrar sesión</a>
</body>
</html>
