<%-- 
    Document   : tablaMediciones
    Created on : 27/04/2022, 11:49:02 PM
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
        <h2 align="center">Historial de mediciones</h2>
        <table border="1" align="center" width=450>
            <thead>
                <tr>
                    <td>id</td>
                    <td>peso</td>
                    <td>cintura</td>
                    <td>cadera</td>
                    <td>fecha</td>
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
        <form name= "tabla" action="index.jsp">
            <table align="center" width=450>
                <tr> 
                    <td><input type="submit" value="Regresar" /></td>
                </tr>      
            </table> 
        </form>
    </body>
</html>
