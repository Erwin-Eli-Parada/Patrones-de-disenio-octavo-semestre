<%-- 
    Document   : obtenerDatos
    Created on : 26/04/2022, 07:09:24 PM
    Author     : ELI
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h2>Bienvenido ${nomUsuario} </h2>
            <%--El nombre de usuario es ${usuario.nombre} con permiso ${usuario.permiso}--%>
            <h2>Cálculo de Kilo calorías</h2>
            <form name="calculo" action="Control">
                <table>
                    <thead>
                        <tr>
                            <td colspan="2"> Datos </td>
                        </tr>
                    </thead>
                    <tr>
                        <td> Nombre: </td>
                        <td name="nombre"> ${usuario.nombre} </td>
                    </tr>
                    <tr>
                        <td> Estatura: </td>
                        <td> <input type="number" step="0.01" name="estatura" value="${usuario.estutura}"/> </td>
                    </tr>
                    <tr>
                        <td> Id: </td>
                        <td> <input type="number" step="0.1" name="id" value="${usuario.idusuario}"/> </td>
                    </tr>
                    <tr>
                        <td> Peso: </td>
                        <td> <input type="number" step="0.1" name="peso"/> </td>
                    </tr>
                    <tr>
                        <td> Cadera: </td>
                        <td> <input type="number" step="0.1" name="cadera"/> </td>
                    </tr>
                    <tr>
                        <td> Cintura: </td>
                        <td> <input type="number" step="0.1" name="cintura"/> </td>
                    </tr>
                    <tr>
                        <td> Tipo de Actividad: </td>
                        <td> 
                            <select name="tipoactividad">
                                <c:forEach var="elemento" items="${actividades}">
                                    <option value="${elemento.idtac}">${elemento.descripcion}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Calcular"/>
            </form>
            <form name= "tabla" action="ControlTablaMediciones">
            <table align="center" width=350>
                <tr> 
                    <td><input type="submit" value="ver registros" /></td>
                </tr>      
            </table> 
        </form>        
        </center>
    </body>
</html>
