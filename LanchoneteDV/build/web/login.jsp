<%-- 
    Document   : longin
    Created on : 13/10/2016, 16:31:08
    Author     : Gilvan Honorato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
   <body align="center" style="background-repeat: no-repeat; background-size:  100%; background-position-x: center">
        <%@include file="Menuhorizontal.jsp" %>
        <br>
        <div class="container">
        <div class="row horizontal-offset-100">
    	<div class="col-md-6 col-md-offset-3">
    	<div class="panel panel-default">
	<div class="panel-heading">
            <h3>Login</h3>
        <form action="LoginServlet" method="post">
            
            
            <div align="right" style="display: inline-block">
            <label>E-mail:</label>
            <input name="usuario" >
            <br>
            <br>
            <label>Senha:</label>
            <input type="password" name="senha">
            <br>
            <br>
            <input type="submit" value="Entrar">
            <input type="submit" value="Cadastrar-se" onclick="location.href = 'Cadastros_Usuarios.jsp'">
            
            <br>
        </form>
    </body>
</html>
