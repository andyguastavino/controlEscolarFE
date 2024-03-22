<%-- 
    Document   : crearCarrera
    Created on : 18 mar 2024, 14:01:51
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear Carrera</title>
    </head>
    <body>
        <h1>Crear Carrera</h1>
         <jsp:include page="menuNavegacion.jsp" />
         
         <form action="Crear" method="post"> 
            <label for="nombre">Nombre Carrera:</label><br>
            <input type="text" id="nombre" name="nombreCarrera" required><br><br>
            <input type="submit" value="Crear Carrera"> 
        </form>
         

    </body>
</html>
