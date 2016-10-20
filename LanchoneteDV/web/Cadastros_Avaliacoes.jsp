<%-- 
    Document   : Cadastros_Avaliacoes
    Created on : 13/10/2016, 15:07:19
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
    <% if(request.getSession().getAttribute("usuario")==null){
        response.sendRedirect("login.jsp");
    }%>
   <body  align="center" style="background-repeat: no-repeat; background-size:  100%; background-position-x: center">
        <%@include file="Menuhorizontal.jsp" %>
         <div class="container">
        <div class="row horizontal-offset-100">
    	<div class="col-md-6 col-md-offset-3">
    	<div class="panel panel-default">
	<div class="panel-heading">
        <form class="form-horizontal" class="form-horizontal" action="AvaliacaoServlet" method="post">
            <div class="form-group">
            <h1>Avaliar</h1>
            <input type="hidden" value="<%=request.getParameter("email")%>" name="estabelecimento">
            <br>
            <br>
            <div align="right" style="display: inline-block">
            <label>Atendimento:</label>
            <input name="atendimento">
            <br>
            <br>
            <label>Qualidade: </label>
            <input name="qualidade">
            <br>
            <br>
            <label> Preco: </label>
            <input name="preco">
            <br>
            <br>
            <label> Tempo de Espera: </label>
            <input name="tempo_espera" >
            <br>
            <br>
             <label> Ambiente: </label>
            <input name="ambiente" >
            <br>
            <br>
            <label> Comentário: </label>
            <input name="comentario" >
            <br>
            <br>
            </div>
            <br>
            
            <input type="submit" value="Salvar">
            </div>
        </form>
            </div>
           </div>
         </div>
        </div>
       </div>
            <%@include file="rodape.jsp" %>
    </body>
</html>

