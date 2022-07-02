<%-- 
    Document   : vistaRegistro
    Created on : 27/04/2022, 04:36:56 PM
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
        <center>
            <h2>Registro de usuario </h2>
            <form name="resgis" action="Regsitro">
                <table>
                    <thead>
                        <tr>
                            <td colspan="2"> Datos </td>
                        </tr>
                    </thead>
                    <tr>
                        <td> Nombre: </td>
                        <td> <input type="text" name="nombre"/> </td>
                    </tr>
                    <tr>
                        <td> Estatura: </td>
                        <td> <input type="number" step="0.01" name="estatura"/> </td>
                    </tr>
                    <tr>
                        <td> Contraseña: </td>
                        <td> <input type="text" name="contra"/> </td>
                    </tr>
                    <tr>
                        <td> Fecha de nacimiento: </td>
                        <td> <input type="text" name="nac"/> </td>
                    </tr>
                    <tr>
                        <td> Sexo: </td>
                        <td> 
                            <select name="sexo">
                                <option value="H">Hombre</option>
                                <option value="M">Mujer</option>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Registro"/>
            </form>
        </center>
    </body>
</html>
