<%-- 
    Document   : listar_lanchonetes
    Created on : 11/10/2016, 00:36:48
    Author     : Gilvan Honorato
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Lanchonetes.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <!-- Última versão CSS compilada e minificada -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Tema opcional -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Última versão JavaScript compilada e minificada -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <link href="estilopaginas.css" rel="stylesheet">
    </head>
   <body lign="center" style="background-repeat: no-repeat; background-size:  100%; background-position-x: center">
        <%@include file="Menuhorizontal.jsp" %> 
        <br>
        <div class="container">
        <div class="row horizontal-offset-100">
    	<div class="col-md-11 col-md-offset-1">
    	<div class="panel panel-default">
	<div class="panel-heading">       
        <h1>Lanchonetes Cadastradas:</h1>
            <br>
            <br>
        <table class="table table-hover" align="center">
            <thead>
                <tr>
                    <td>Estabelecimento</td>
                    <td>Rua</td>
                    <td>Numero</td>
                    <td>Bairro</td>
                    <td>Cidade</td>
                    <td>Telefone</td>
                    <td>Email</td>
                    
                    
                    
                </tr>
            </thead>
            <tbody>
                <% for (Lanchonete lanchonete : LanchoneteDAO.listar()) { %>
                <tr>
                    <td> <%= lanchonete.nome %> </td>
                    <td> <%= lanchonete.rua %> </td>
                    <td> <%= lanchonete.numero %> </td>
                    <td> <%= lanchonete.bairro %> </td>
                    <td> <%= lanchonete.cidade %> </td>
                    <td> <%= lanchonete.telefone %> </td>
                    <td> <%= lanchonete.email %> </td>
                    <td>                     
                    <a href="Cadastros_Avaliacoes.jsp?email=<%= lanchonete.email %> "> 
                        
                        Avaliar
                        
                    </a>
                    </td>
                    <td>
                     <a href="listar_avaliacoes.jsp?email=<%= lanchonete.email %> "> 
                        
                        Avaliações
                        
                    </a>
                    </td>
                                        
                <% } %>
                
            </tbody>

        </table>
        </div>
        </div>
        </div>
        </div>
        </div>  
                <br>
                <br>
                <%@include file="rodape.jsp" %>        
    </body>
</html>

