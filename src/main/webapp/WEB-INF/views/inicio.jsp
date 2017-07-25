<%-- 
    Document   : inicio
    Created on : 24/07/2017, 06:19:38 PM
    Author     : mq12
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Rest Spring</title>
    </head>
    <body>
        <h1>Client Rest Spring</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>LOCAL</th>
                    <th>GOLES LOCAL</th>
                    <th>VISITA</th>
                    <th>GOLES VISITA</th>
                    <th>ESTADIO</th>
                    <th>FECHA</th>
                    <th>TORNEO</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> ${partido.id}</td>
                    <td>${partido.local}</td>
                    <td>${partido.goleslocal}</td>
                    <td>${partido.visita}</td>
                    <td>${partido.golesvista}</td>
                    <td>${partido.estadio}</td>
                    <td>${partido.fecha}</td>
                    <td>${partido.torneo}</td>
                    
                </tr>
            </tbody>
        </table>


       

    </body>
</html>
