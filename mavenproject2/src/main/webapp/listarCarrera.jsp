<%-- 
    Document   : listarCarrera
    Created on : 18 mar 2024, 13:50:17
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <h1>Lista de Carreras</h1>
         <jsp:include page="menuNavegacion.jsp" />
         <form action="Listar" method="get"> 
         
            <input type="submit" value="VER LISTA CARRERAS"> 
        </form>
          <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre de la Carrera</th>
                <th>Acciones</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach var="carrera" items="${carreras}">
                <tr>
                    <td>${carrera.id}</td> 
                    <td>${carrera.nombre}</td>
                    <td>
                        <form action="Listar" method="post"> 
                             <input type="hidden" name="idCarrera" value="${carrera.id}">
                            <input type="submit" value="Eliminar"> 
                         </form>
                    
                    
                    </td> 
                     
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <%-- Si deseas mostrar algún mensaje de error, puedes hacerlo aquí --%>
    <% if (request.getAttribute("error") != null) { %>
        <p>Error: ${request.getAttribute("error")}</p>
    <% } %>
    </body>
</html>
