<%-- 
    Document   : index
    Created on : 19/04/2022, 05:54:07 PM
    Author     : ELI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo</title>
    </head>
    <body>
        <form name= autentication" action="Acceso" method="post">
            <h2  align="center">Ingresar al sistema</h2>
            <table align="center" width=350 style="boder-style:black">
                <thead>
                    <tr>
                        <th colspan="2">Acceso para el calculo kilocalorias</th>
                    </tr>
                </thead>
                <tbody>
                    <tr> 
                        <td>Usuario:</td>
                        <td> <input type="text" name="nombreUsuario" value=""/></td>
                    </tr>
                    <tr> 
                        <td>Clave:</td>
                        <td> <input type="password" name="clave" value=""/></td>
                    </tr>
                    <tr> 
                        <td colspan="2"><input type="submit" value="ingresar" /></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        <form name= "regitro" action="vistaRegistro.jsp">
            <table align="center" width=350>
                <tr> 
                    <td colspan="2"><input type="submit" value="registrar" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
