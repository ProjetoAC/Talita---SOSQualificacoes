 <%@page import="Usuarios.UsuarioDAO"%>
<%@page import="Usuarios.Usuario"%>
<%-- 
    Document   : listar_usuarios
    Created on : 11/10/2016, 00:36:12
    Author     : Gilvan Honorato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Usuarios.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Tema opcional -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Última versão JavaScript compilada e minificada -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link rel="stylesheet" type="text/css" href="estilopaginas.css">
    </head>
   <body  align="center" style="background-repeat: no-repeat; background-size:  100%; background-position-x: center">
        <%@include file="Menuhorizontal.jsp" %>
        <br>
        <div class="container">
        <div class="row horizontal-offset-100">
    	<div class="col-md-6 col-md-offset-3">
    	<div class="panel panel-default">
	<div class="panel-heading">
        <div align="center">
        <h1>Usuarios Cadastrados:</h1>
            <br>
            <br>
         <div align="center">   
        <table border="1">
            <thead>
                <tr>
                    <td>Nome e Sobrenome</td>
                    <td>Data de Nascimento</td>
                    <td>Rua</td>
                    <td>Numero</td>
                    <td>Bairro</td>
                    <td>Cidade</td>
                    <td>Telefone</td>
                    <td>Email</td>
                    
                    
                </tr>
            </thead>
            <tbody>
                <% for (Usuario usuario : UsuarioDAO.listar()) { %>
                <tr>
                    <td> <%= usuario.nome_sobrenome %> </td>
                    <td> <%= usuario.data_nascimento %> </td>
                    <td> <%= usuario.rua %> </td>
                    <td> <%= usuario.numero %> </td>
                    <td> <%= usuario.bairro %> </td>
                    <td> <%= usuario.cidade %> </td>
                    <td> <%= usuario.telefone %> </td>
                    <td> <%= usuario.email %> </td>
                    
                  
                  </tr>
                <% } %>
            </tbody>
         </div>
        </table>
        
    </body>
</html>

