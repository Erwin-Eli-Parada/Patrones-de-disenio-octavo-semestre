<%-- 
    Document   : resultados
    Created on : 27/04/2022, 08:56:19 PM
    Author     : ELI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2  align="center">Resultados del sistema</h2>
        <form name= regreso" action="RegistrarDatos">
            <table border="1" align="center" width=350 style="boder-style:black">
                <thead>
                    <tr>
                        <th colspan="2">Resultados de salud</th>
                    </tr>
                </thead>
                <tbody>
                    <tr> 
                        <td>Nombre:</td>
                        <td>${usuario.nombre}</td>
                    </tr>
                    <tr> 
                        <td>Id usuario:</td>
                        <td>${usuario.idusuario}</td>
                    </tr>
                    <tr> 
                        <td>Estatura:</td>
                        <td>${usuario.estutura}</td>
                    </tr>
                    <tr> 
                        <td>Fecha:</td>
                        <td> ${is.fecha}</td>
                    </tr>
                    <tr> 
                        <td>Peso:</td>
                        <td> ${is.peso}</td>
                    </tr>
                    <tr> 
                        <td>Cintura:</td>
                        <td> ${is.cintura}</td>
                    </tr>
                    <tr> 
                        <td>Cadera:</td>
                        <td> ${is.cadera}</td>
                    </tr>
                    <tr> 
                        <td>IMC:</td>
                        <td> ${imc}</td>
                    </tr>
                    <tr> 
                        <td>ICC:</td>
                        <td> ${icc}</td>
                    </tr>
                    <tr> 
                        <td>Id actividad:</td>
                        <td> ${is.tipoactividad}</td>
                    </tr>
                </tbody>
            </table>
            <table align="center" width=350>
                <tr> 
                    <td><input type="submit" value="registrar" /></td>

                </tr>      
            </table>           
        </form>
        
        <form name= "tabla" action="index.jsp">
            <table align="center" width=350>
                <tr> 
                    <td><input type="submit" value="Regresar" /></td>
                </tr>      
            </table> 
        </form>
        
    </body>
</html>
