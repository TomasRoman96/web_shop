<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="public/css/style.css">
    <link rel="stylesheet" href="public/lib/bootstrap/bootstrap.css">
    <script src = "public/lib/bootstrap/popper.min.js"></script>
    <script src = "public/lib/bootstrap/bootstrap.js"></script>

</head>
<body>
    <div class = "container d-flex justify-content-center">
      <div class="form-container"
        <form>
            <div class="mb-3">
              <label for="userame" class="form-label">Usuario</label>
              <input type="text" class="form-control" id="username" autocomplete="off" aria-describedby="username">
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Contraseña</label>
              <input type="password" class="form-control" id="password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
          </div>
    </div>
</body>
</html>