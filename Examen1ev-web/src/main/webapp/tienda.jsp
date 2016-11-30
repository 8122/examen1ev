<%-- 
    Document   : tienda
    Created on : 30-nov-2016, 9:41:43
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>¡Bienvenido a la tienda!</h1>
        <p><a href="">Identificarse/Registrarse</a></p>
        <table border="1">
            <thead>
                <tr>
                    <th>Id Producto</th>
                    <th>Imagen</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Producto> lista = (ArrayList) session.getAttribute("productosTienda");
                for(Producto p: lista){
                    int id = p.getId();
                    String imagen = p.getImagen();
                    String descripcion = p.getDescripcion();
                    double precio = p.getPrecio();
            %>
                <tr>
                    <td><%=id%></td>
                    <td><img src="<%=imagen%>"></td>
                    <td><%=descripcion%></td>
                    <td><%=precio%></td>
                    <td><a href="ComprarProducto?accion=validar&id=<%=id%>">Comprar</td>
                </tr>
            <%}%>
            </tbody>
        </table>

    </body>
</html>
