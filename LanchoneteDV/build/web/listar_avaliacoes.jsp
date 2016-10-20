<%-- 
    Document   : listar_avaliacoes
    Created on : 11/10/2016, 00:37:17
    Author     : Gilvan Honorato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Avaliacoes.*" %>
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
   <body action="AvaliacaoServlet" background= "fundo" align="center" style="background-repeat: no-repeat; background-size:  100%; background-position-x: center">
       <%@include file="Menuhorizontal.jsp" %>  
       <br>
        <div class="container">
        <div class="row horizontal-offset-100">
    	<div class="col-md-11 col-md-offset-0,75">
    	<div class="panel panel-default">
	<div class="panel-heading">
       <h1>Avaliações</h1>
       <p>
        <div align="center">
        <table class="table table-bordered" align="center">
            <thead>
                <tr>
                    <td>Atendimento</td>
                    <td>Qualidade</td>
                    <td>Preço</td>
                    <td>Tempo de Espera</td>
                    <td>Ambiente</td>
                    <td>Comentário</td>
                    <td>Usuario</td>
                    <td>Estabelecimento</td>
                    
                    
                </tr>
            </thead>
            <tbody>
                <% String email = request.getParameter("email");
                 for (Avaliacao avaliacao : AvaliacaoDAO.listar(email)) { %>
                <tr>
                    <td> <%= avaliacao.atendimento%> </td>
                    <td> <%= avaliacao.qualidade%> </td>
                    <td> <%= avaliacao.preco%> </td>
                    <td> <%= avaliacao.tempo_espera%> </td>
                    <td> <%= avaliacao.ambiente%> </td>
                    <td> <%= avaliacao.comentario%> </td>
                    <td> <%= avaliacao.usuario.nome_sobrenome%> </td>
                    <td> <%= avaliacao.estabelecimento.nome%> </td>
                  </tr>
                <% } %>
            </tbody>
        </table>
        
    </body>
</html>