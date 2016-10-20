<%-- 
    Document   : Cadastros_Estabelecimentos
    Created on : 10/10/2016, 16:08:01
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
       <h1>Cadastre seu Estabelecimento</h1>
         <form class="form-horizontal"class="form-horizontal" action="LanchoneteServlet" method="post">
          <div class="form-group">
            <br>
            <br>
            <div align="right" style="display: inline-block">
            <label>Nome:</label>
            <input name="nome" placeholder="Nome da Lanchonete">
            <br>
            <br>
            <label> Logradouro: </label>
            <input name="rua" placeholder="Nome da rua">
            <br>
            <br>
            <label> Numero: </label>
            <input name="numero" placeholder="Ex: Nº0">
            <br>
            <br>
            <label> Bairro: </label>
            <input name="bairro" placeholder="Bairro">
            <br>
            <br>
            <label> Cidade/Estado: </label>
            <input name="cidade" placeholder="São Paulo, SP">
            <br>
            <br>
            <label> Telefone: </label>
            <input name="telefone" placeholder="(00) 9999-9999">
            <br>
            <br>
            <label> E-mail: </label>
            <input name="email" placeholder="exemplo@hotmail.com">
            <br>
            <br>
            <div style="width: 100%; text-align: center"> Cadastrar Senha:</div>
            <br>
            <label> Senha: </label>
            <input type="password" name="senha">
            <br>
            <br>
            <label> Confirma senha: </label>
            <input type="password" name="confirmacao_senha">
            <br>
            <br>
            </div>
            <br>            
            <input type="submit" value="Cadastrar e Salvar">
          </div>
             </form>
          </div>
        </div>
        </div>
          </div>
        </div>
        
       
      </body>
</html>
