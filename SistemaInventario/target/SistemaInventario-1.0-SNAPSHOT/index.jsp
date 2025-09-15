<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - Inventario Panadería</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.8/css/line.css">
</head>
<body>

    <div class="container">
        <!-- LOGIN -->
        <div class="container-form"> 
            <form class="sign-in" action="LoginServlet" method="post">
                <h2>Inicio de Sesión - Inventario</h2>
                <span>Inicia sesión con el usuario y contraseña</span>
                <div class="container-input">
                    <ion-icon name="person"></ion-icon>
                    <input type="text" name="nombre_usuario" placeholder="Usuario" required>
                </div>
                <div class="container-input">
                    <ion-icon name="lock-closed"></ion-icon>
                    <input type="password" name="contraseña" placeholder="Contraseña" required>
                </div>
                <a href="#">¿Olvidaste tu contraseña?</a> 
                <button class="button" type="submit">Iniciar sesión</button>
            </form>
        </div>

        <!-- REGISTRO -->
        <div class="container-form">
            <form class="sign-up" action="RegisterServlet" method="post">
                <h2>Registra un usuario</h2>
                <span>Registra con los siguientes datos</span>
                <div class="container-input">
                    <ion-icon name="person-add-outline"></ion-icon>
                    <input type="text" name="nombre" placeholder="Nombre" required>
                </div>
                <div class="container-input">
                    <ion-icon name="person-add-outline"></ion-icon>
                    <input type="text" name="apellido" placeholder="Apellido" required>
                </div>
                <div class="container-input">
                    <ion-icon name="mail-outline"></ion-icon>
                    <input type="email" name="correo" placeholder="Correo" required>
                </div>
                <div class="container-input">
                    <ion-icon name="person"></ion-icon>
                    <input type="text" name="nombre_usuario" placeholder="Usuario" required>
                </div>
                <div class="container-input">
                    <ion-icon name="lock-closed"></ion-icon>
                    <input type="password" name="contraseña" placeholder="Contraseña" required>
                </div>
                <button class="button" type="submit">Registrar</button>
            </form>
        </div>

        <!-- PANEL ANIMADO -->
        <div class="container-welcome">
            <div class="welcome-sign-in welcome">
                <h3>¡Bienvenido!</h3>
                <p>Registre un nuevo usuario para que pueda acceder al inventario</p>
                <p>o</p>
                <p>Inicie sesión si ya tiene una cuenta</p>
                <button class="button" id="btn-sign-in">Inicia Sesión</button>
            </div>
            <div class="welcome-sign-up welcome">
                <h3>¡Hola!</h3>
                <p>Ingrese sus datos para acceder al inventario</p>
                <p>o</p>
                <p>Registre un nuevo usuario</p>
                <button class="button" id="btn-sign-up">Registrar</button>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <!-- mensajes dinámicos -->
    <%
        String registroStatus = (String) session.getAttribute("registroStatus");
        String loginStatus = (String) session.getAttribute("loginStatus");

        if ("ok".equals(registroStatus)) {
    %>
        <script>
            Swal.fire({
                title: "Bien!",
                text: "Usuario registrado correctamente",
                icon: "success"
            });
        </script>
    <%
        } else if ("error".equals(registroStatus)) {
    %>
        <script>
            Swal.fire({
                title: "Error",
                text: "El usuario ya existe o hubo un error en el registro",
                icon: "error"
            });
        </script>
    <%
        }

        if ("error".equals(loginStatus)) {
    %>
        <script>
            Swal.fire({
                title: "Acceso denegado",
                text: "Usuario o contraseña incorrectos",
                icon: "error"
            });
        </script>
    <%
        }

        session.removeAttribute("registroStatus");
        session.removeAttribute("loginStatus");
    %>

    <%
        String errorLogin = (String) request.getAttribute("errorLogin");
        if (errorLogin != null) {
    %>
        <script>
            Swal.fire({
                title: "Error",
                text: "<%= errorLogin %>",
                icon: "error",
                confirmButtonText: "Aceptar"
            });
        </script>
    <%
        }
    %>

    <script src="js/script.js"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    <script>
        Swal.mixin({
            scrollbarPadding: false,
            heightAuto: false
        });
    </script>

</body>
</html>
