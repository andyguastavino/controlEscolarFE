<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Modificar Carrera</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
    <h1>Modificar Carrera</h1>
    
    <jsp:include page="menuNavegacion.jsp" />

    <form action="Modificar" method="post">
        <label for="carrera">Carrera a modificar:</label>
        <input type="text" id="carrera" name="carrera" required>
        <br>
        <label for="nuevaCarrera">Nueva carrera:</label>
        <input type="text" id="nuevaCarrera" name="nuevaCarrera" required>
        <br>
        <button type="submit">Modificar Carrera</button>
    </form>
</body>
</html>
